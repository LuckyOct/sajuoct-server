package com.luckyoct.sajuoct.user.dao;

import com.luckyoct.sajuoct.user.dto.LoginType;
import com.luckyoct.sajuoct.user.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findBySocialIdAndLoginType(String socialId, LoginType loginType);
}
