package spring_basic.spring_basic_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring_basic.spring_basic_api.entity.User;
import spring_basic.spring_basic_api.request.auth.RegisterUserRequest;
import spring_basic.spring_basic_api.request.user.UpdateUserRequest;
import spring_basic.spring_basic_api.response.user.UserResponse;
import spring_basic.spring_basic_api.response.WebResponse;
import spring_basic.spring_basic_api.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> getCurrentUser(User user) {
        UserResponse currentUser = userService.getCurrentUser(user);
        return WebResponse.<UserResponse>builder().data(currentUser).build();
    }

    @PatchMapping(
            path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> update(User user, @RequestBody UpdateUserRequest request) {
        UserResponse updatedUser = userService.update(user, request);
        return WebResponse.<UserResponse>builder().data(updatedUser).build();
    }

}
