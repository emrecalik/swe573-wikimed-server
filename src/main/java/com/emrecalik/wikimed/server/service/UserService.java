package com.emrecalik.wikimed.server.service;

import com.emrecalik.wikimed.server.domain.User;
import com.emrecalik.wikimed.server.model.response.UserDetailsResponseDto;

public interface UserService {
    User findByUserName(String userName);

    boolean existByUserName(String userName);

    boolean existByEmail(String email);

    void save(User user);

    User getUserProxyById(Long id);

    User getUserById(Long id);

    UserDetailsResponseDto getUserDetails(Long userId, Long requesterId);

    UserDetailsResponseDto followUser(Long userId, Long followeeId);

    UserDetailsResponseDto unFollowUser(Long userId, Long followeeId);
}
