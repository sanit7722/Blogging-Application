# Blogging App Website
<h1 align="center">
  <br>
  <img src="https://user-images.githubusercontent.com/33577947/180727734-36effef4-9847-4689-bb29-a52ffd319bd5.png" alt="Foco" height="160" width="160">
</h1>

## Getting Started
This app is mainly categorised into three major sections:
* ### Admin Section: [Role: ADMIN]
  - **Monitor User:** Admin can monitor all the users and can delete user for violating rules. 
  - **Monitor Post:** Admin can monitor all posts and can delete post of any of the user.
  - **Monitor Comments:**  Admin can monitor all comments and can delete comment of any of the user.
  - **Category:**  Admin can Add/Edit blog category.
   
* ### Normal user Section: [Role: NORMAL]
  - **Profile:** User can add/edit his/her name, email, about. 
  - **Post:** User can create post with any category added by Admin or can edit his own post.
  - **Comments:** User can comment on any post and can delete his/her own comment.
* ### Any anonymous User: [Role: NONE]
  - **Website Page:** Any anonymous user can see our website. He/She has access to view all posts and about-us, contact-us page.
  - **Login/Register**: Users can also Register to Website, Login into the website. 

## Video Demo (Time: 2 minute)
Coming soon

## Features
* Different User Profiles/Roles: ADMIN, NORMAL.
* Sign In, Register & Reset Password functionlity with Spring Security.
* Storing and displaying posts, comments from MySQL Database with power of JPA & Hibernate.
* Clean & Simple UI.
* Adding post dynamically with create/edit post feature for user.
* JPA Pagination & Sorting for simplifying the user experience.
* Adding comments to the post and also showing user who added comments.
* Validating each and every field in form with @Valid annotation.
* Giving the ability to user to edit/add things in his own profile.
* Securing & adding Autorization to APIs with Spring Security.
* Giving access to swagger for documenting APIs.
* Segregation of code into multiple packages like Controller, Service, Model, Security, Repository, Constants etc., for better understanding.

## Built With
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombok](https://projectlombok.org/)
- [Spring Dev Tools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)
- [Spring REST APIs](https://spring.io/projects/spring-restdocs)
- [Bootstrap](https://getbootstrap.com/)
- [MySQL Database](https://www.mysql.com/)
- [React JS](https://reactjs.org/)

## Database Schema Diagram

![Capture](https://user-images.githubusercontent.com/42400759/181925420-c9c45ee8-f3f4-4d11-926b-2cf0f5e9bc57.JPG)

## Visit our Website
Comming soon

## Contributing
1. Fork it (<https://github.com/sanit7722/Blogging-Application/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request :D

<br>
<div align="center">
  <h3>Proudly :muscle: made with <b><a href="https://spring.io/">Spring</a> :sparkling_heart:</b></h3>
</div>
<br>

## License
-------

    The MIT License (MIT)
    
    Copyright (c) 2022 Sanit Dhuri
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
