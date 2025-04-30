# TaskQueue Java Program

This is a Java-based program to manage a task queue. The program allows you to enqueue tasks, assign tasks to workers, complete tasks, and retry failed tasks. 

## Features:
- **Enqueue a Task**: Adds a new task to the queue.
- **Assign Task to Worker**: Assigns a task to an available worker.
- **Complete Task**: Marks the task as completed if it's assigned to the correct worker.
- **Fail or Retry Task**: Allows for retrying a failed task by re-enqueuing it.


## Requirements:
- Java 8 or higher installed on your machine.
- If you do not have javayou can install it or run the content of Main.java file on any Online Java Compiler.

## Setup and Running the Program:

### 1. Install Java

Before running the program, make sure you have **Java** installed on your system. You can check the installation with the following command:

```bash
java -version
```

### 2. Clone or Download the Program

If you’re using version control (e.g., Git), you can clone the repository or simply download the Java source file.

```
git clone <repository-url>

```
Or download Main.java

### 3. Compile the Program
Open a terminal or command prompt and navigate to the directory where Main.java is located.

To compile the program, run the following command:

```
javac Main.java

```
This will generate the Main.class bytecode file.

### 4. Run the Program
Once the program is compiled, you can run it using the java command:

```
java Main

```

You should see the output based on the sample inputs, such as tasks being assigned, completed, or retried.

## Example Output:

```
Assign task to worker A: 1
Assign task to worker B: 2
Assign task to worker C: 3
Complete task 1 by worker A: true
Fail task 2 by worker B: true
Re-assign task 2 to worker C: 2
Status of task 1: 2
Status of task 2: 0

```

### 5. Modify and Test
Feel free to modify the Main class to change the sequence of tasks or add more tests for your needs. You can enqueue more tasks, assign them to different workers, or simulate different scenarios.


## Additional Information:
- **taskQueue.enqueueTask(taskId)**: This method is used to add tasks to the queue with a given task ID.
- **taskQueue.assignTaskToWorker(workerId)**: Assigns the next task from the queue to the worker.
- **taskQueue.completeTask(taskId, workerId)**: Marks the task as completed if the correct worker completes it.
- **taskQueue.failTask(taskId, workerId)**: If a task fails, it is re-enqueued for retry.

## Making TaskQueue Thread-safe
In addition to the above functionality, we can make the program thread-safe if multiple threads (workers) are running simultaneously. We need to ensure that tasks are correctly assigned, marked as in-progress, completed, or retried without interfering with each other.

To achieve this we can follow the below steps.
- we can make use of concurrentLinkedQueue and concurrentHashmap
   public TaskQueue() {
        taskQueue = new ConcurrentLinkedQueue<>();
        taskStatus = new ConcurrentHashMap<>();
        taskWorkers = new ConcurrentHashMap<>();
    }

- Synchronized Methods:

The methods **enqueueTask(), assignTaskToWorker(), completeTask(), and failTask() are marked as 'synchronized'**. This ensures that only one thread can access these methods at a time, which is important because tasks are being added, assigned, completed, and retried concurrently.

Although ConcurrentLinkedQueue and ConcurrentHashMap handle thread safety for their operations internally, we can still use synchronized to ensure that multiple operations on the queue or task status are consistent and atomic.

Example:

```
 public synchronized void enqueueTask(int taskId) {
//implementation
}
```


