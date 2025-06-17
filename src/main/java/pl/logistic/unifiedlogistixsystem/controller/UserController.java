package pl.logistic.unifiedlogistixsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.logistic.unifiedlogistixsystem.dto.UserDto;
import pl.logistic.unifiedlogistixsystem.mapper.UserMapper;
import pl.logistic.unifiedlogistixsystem.model.User;
import pl.logistic.unifiedlogistixsystem.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username)
                .map(user -> ResponseEntity.ok(userMapper.toDto(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        if (userService.existsByUsername(userDto.getUsername()) || userService.existsByEmail(userDto.getEmail())) {
            return ResponseEntity.badRequest().build();
        }

        User user = userMapper.toEntity(userDto);
        User saved = userService.saveUser(user);
        return ResponseEntity.ok(userMapper.toDto(saved));
    }
}
