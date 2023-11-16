package com.example.exercise13crud.Controller;

import com.example.exercise13crud.ApiResponse.ApiResponse;
import com.example.exercise13crud.Model.TaskTracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task-tracker")
public class TaskTrackerController {
    ArrayList<TaskTracker> taskTrackers = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<TaskTracker> getTaskTrackers(){

        return taskTrackers;
    }

    @PostMapping("/add")
    public ApiResponse addTaskTracker(@RequestBody TaskTracker taskTracker){
        taskTrackers.add(taskTracker);

        return new ApiResponse("task added",200);

    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTaskTracker(@PathVariable int index,@RequestBody TaskTracker taskTracker){
        taskTrackers.set(index,taskTracker);

        return new ApiResponse("task updated",200);
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTaskTracker(@PathVariable int index){
        taskTrackers.remove(index);
        return new ApiResponse("task deleted",200);

    }

    @PutMapping("/change-status/{index}")
    public ApiResponse changeTaskStatus(@PathVariable int index){
        if(taskTrackers.get(index).getStatus().equals("done")){
            taskTrackers.get(index).setStatus("not done");
        }else taskTrackers.get(index).setStatus("done");

        return new ApiResponse("task status changed",200);

    }
    @GetMapping("/search-task/{title}")
    public TaskTracker searchTask(@PathVariable String title){
        for(TaskTracker t : taskTrackers){
            if(t.getTitle().equals(title)){
                return t;

            }
        }
        return null;

    }


}
