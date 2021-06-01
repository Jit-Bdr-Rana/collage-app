package com.college.service;

import com.college.model.Student;
import com.college.model.User;

public interface UserService {
 public void saveUser(User user);
 public User fetchStudentFromEmail(String email);
}
