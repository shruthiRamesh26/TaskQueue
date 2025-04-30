package com.example.demo;

public class Main {
    public static void main(String[] args) {

        TaskQueue taskQueue = new TaskQueue();

        // Enqueue some tasks
        taskQueue.enqueueTask(1);
        taskQueue.enqueueTask(2);
        taskQueue.enqueueTask(3);

        // Assign tasks to workers
        System.out.println("Assign task to worker A: " + taskQueue.assignTaskToWorker("A"));
        System.out.println("Assign task to worker B: " + taskQueue.assignTaskToWorker("B"));
        System.out.println("Assign task to worker C: " + taskQueue.assignTaskToWorker("C"));

        // Complete a task
        System.out.println("Complete task 1 by worker A: " + taskQueue.completeTask(1, "A"));

        // Fail or retry a task
        System.out.println("Fail task 2 by worker B: " + taskQueue.failTask(2, "B"));
        System.out.println("Re-assign task 2 to worker C: " + taskQueue.assignTaskToWorker("C"));

        // Check status of tasks
        System.out.println("Status of task 1: " + taskQueue.getTaskStatus(1));
        System.out.println("Status of task 2: " + taskQueue.getTaskStatus(2));
    }
}