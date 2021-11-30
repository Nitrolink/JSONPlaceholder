package com.foundry.placeholder;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.foundry.placeholder.Models.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class PlaceholderController {
    private final String URL = "https://jsonplaceholder.typicode.com/";


//    @GetMapping("/users/{id}")
//    public User getUserID(@PathVariable String id, RestTemplate restTemplate){
//        return restTemplate.getForObject(URL + "users/"+ id, User.class);
//    }
//
//    @GetMapping("/users")
//    public User[] getUserRange(RestTemplate restTemplate, @RequestParam(name = "start", required = false) String start, @RequestParam(name = "end", required = false) String end){
//        if(start == null){
//            return restTemplate.getForObject(URL + "users/", User[].class);
//        }
//        else{
//            ArrayList<User> users = new ArrayList<>();
//            for (int i = Integer.parseInt(start); i <= Integer.parseInt(end); i++) {
//                users.add(restTemplate.getForObject(URL + "users/" + i, User.class));
//            }
//            return users.toArray(new User[0]);
//        }
//    }
//
//
//    @GetMapping("/photos/{id}")
//    public Photo getPhotoID(@PathVariable String id, RestTemplate restTemplate){
//        return restTemplate.getForObject(URL + "photos/"+ id, Photo.class);
//
//    }
//
//    @GetMapping("/photos")
//    public Photo[] getPhotoRange(RestTemplate restTemplate, @RequestParam(name = "start", required = false) String start, @RequestParam(name = "end", required = false) String end){
//        if(start == null){
//            return restTemplate.getForObject(URL + "photos/", Photo[].class);
//        }
//        else{
//            ArrayList<Photo> photos = new ArrayList<>();
//            for (int i = Integer.parseInt(start); i <= Integer.parseInt(end); i++) {
//                photos.add(restTemplate.getForObject(URL + "photos/" + i, Photo.class));
//            }
//            return photos.toArray(new Photo[0]);
//        }
//
//    }

    @GetMapping(value = {"/users", "/users/{id}"})
    public Object getUsers(RestTemplate restTemplate, @PathVariable (name = "id", required = false) String id,  @RequestParam(name = "start", required = false) String start, @RequestParam(name = "end", required = false) String end){
        if(id == null){
            if(start == null){
                return restTemplate.getForObject(URL + "users/", User[].class);
            }
            else{
                ArrayList<User> users = new ArrayList<>();
                for (int i = Integer.parseInt(start); i <= Integer.parseInt(end); i++) {
                    users.add(restTemplate.getForObject(URL + "users/" + i, User.class));
                }
                return users.toArray(new User[0]);
            }
        }
        else{
            return restTemplate.getForObject(URL + "users/"+ id, User.class);
        }

    }

    @GetMapping(value = {"/photos", "/photos/{id}"})
    public Object getPhotos(RestTemplate restTemplate, @PathVariable (name = "id", required = false) String id,  @RequestParam(name = "start", required = false) String start, @RequestParam(name = "end", required = false) String end){
        if(id == null){
            if(start == null){
                return restTemplate.getForObject(URL + "photos/", Photo[].class);
            }
            else{
                ArrayList<Photo> photos = new ArrayList<>();
                for (int i = Integer.parseInt(start); i <= Integer.parseInt(end); i++) {
                    photos.add(restTemplate.getForObject(URL + "photos/" + i, Photo.class));
                }
                return photos.toArray(new Photo[0]);
            }
        }
        else{
            return restTemplate.getForObject(URL + "photos/"+ id, Photo.class);
        }
    }




}
