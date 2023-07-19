package com.example.k230327_android_lab

import java.util.Scanner

// User 클래스 정의
data class User(val id: String, val pw: String, val email: String, val phone: String)

// Login 클래스 정의
class Login {
    // 로그인 처리 메소드
    fun login(user: User) {
        // Scanner 객체 생성
        val scanner = Scanner(System.`in`)
        // ID와 비밀번호 입력 받기
        print("ID를 입력하세요: ")
        val inputId = scanner.nextLine()
        print("비밀번호를 입력하세요: ")
        val inputPw = scanner.nextLine()
        // ID와 비밀번호가 일치하는지 확인
        if (inputId == user.id && inputPw == user.pw) {
            // 일치하면 로그인 성공 메시지 출력
            println("로그인 되었습니다. ${user.id}님 환영합니다.")
        } else {
            // 일치하지 않으면 로그인 실패 메시지 출력
            println("로그인에 실패했습니다. ID와 비밀번호를 확인하세요.")
        }
    }
}

// Register 클래스 정의
class Register {
    // 회원 가입 처리 메소드
    fun register(): User {
        // Scanner 객체 생성
        val scanner = Scanner(System.`in`)
        // 회원 가입 정보 입력 받기
        print("ID를 입력하세요: ")
        val id = scanner.nextLine()
        print("비밀번호를 입력하세요: ")
        val pw = scanner.nextLine()
        print("이메일을 입력하세요: ")
        val email = scanner.nextLine()
        print("전화번호를 입력하세요: ")
        val phone = scanner.nextLine()
        // User 객체 생성 및 반환
        return User(id, pw, email, phone)
    }
}

// 실행 클래스 정의
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        // Register 객체 생성
        val register = Register()
        // 회원 가입 처리 후 User 객체 받기
        val user = register.register()
        // Login 객체 생성
        val login = Login()
        // 로그인 처리 메소드 호출
        login.login(user)
    }
}
