package org.kitri.myspringboard.sevice;


import org.kitri.myspringboard.domain.Users;
import org.kitri.myspringboard.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersMapper usersMapper;

    public void save(Users users) {
        if(!users.getPassword().equals(users.getPasswordConfirm())) {
            throw new RuntimeException("Password does not match confirm password");
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        users.setEnabled(true);

        // 사용자 저장
        usersMapper.insertUser(users);

        // 권한 저장
        usersMapper.insertAuthority(users.getId(), "ROLE_USER");
    }
}
