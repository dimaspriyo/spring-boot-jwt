
  
# Spring Boot JWT Authentication using filter

 ## Getting Started

 1. Create new user using `/api/registration` with
 ```
 {
"username" : "admin",
"password" : "admin"
}
```

2. Get JWT Token using `/api/login` with
 ```
 {
"username" : "admin",
"password" : "admin"
}
```

3.  Hit `/api` with
```
Header
Authorization : Bearer xxxxx
```
