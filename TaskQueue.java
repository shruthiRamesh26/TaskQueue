package com.example.demo;

import java.util.*;


public class TaskQueue {


        // Queue to store tasks
        private Queue<Integer> taskQueue;

        // Map to store task status: 0 for pending, 1 for in-progress, 2 for completed
        private Map<Integer, Integer> taskStatus;

        // Map to store which worker is working on which task
        private Map<Integer, String> taskWorkers;

        public TaskQueue() {
            taskQueue = new LinkedList<>();
            taskStatus = new HashMap<>();
            taskWorkers = new HashMap<>();
        }

        // Enqueue a Task
        public void enqueueTask(int taskId) {
            taskQueue.offer(taskId);
            taskStatus.put(taskId, 0); // Task is initially in pending state
        }

        // Assign Task to a Worker
        public Integer assignTaskToWorker(String workerId) {
            if (taskQueue.isEmpty()) {
                return null; // No tasks available
            }

            Integer taskId = taskQueue.poll();
            if (taskStatus.get(taskId) == 0) { // Task is pending
                taskStatus.put(taskId, 1); // Mark task as in-progress
                taskWorkers.put(taskId, workerId); // Assign worker to task
                return taskId;
            }


            return null;
        }

        // Complete Task
        public boolean completeTask(int taskId, String workerId) {
            if (taskStatus.containsKey(taskId) && taskStatus.get(taskId) == 1 && taskWorkers.get(taskId).equals(workerId)) {
                taskStatus.put(taskId, 2); // Mark task as completed
                taskWorkers.remove(taskId); // Remove the worker's assignment
                return true;
            }
            return false;
        }

        // Fail or Retry Task
        public boolean failTask(int taskId, String workerId) {
            if (taskStatus.containsKey(taskId) && taskStatus.get(taskId) == 1 && taskWorkers.get(taskId).equals(workerId)) {
                // Re-enqueue the task at the back of the queue
                taskStatus.put(taskId, 0); // Task is back to pending state
                taskWorkers.remove(taskId); // Remove worker assignment
                taskQueue.offer(taskId); // Re-enqueue the task
                return true;
            }
            return false;
        }

        // For debugging: Get task status
        public String getTaskStatus(int taskId) {
            return taskStatus.containsKey(taskId) ? taskStatus.get(taskId).toString() : "Task not found";
        }
    }



