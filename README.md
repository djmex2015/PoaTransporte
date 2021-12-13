# PoaTransporte

**Front-End**: Basically the implementation was done with Angular 7 (7.3.9) and I used Node.JS (10.15) as a development platform also taking advantage of its very good support.
 If the site were produced, Apache would be a good option.
I also used a proprietary bootstrap model (some components weren't very aligned as there isn't much support for it and its code-handling extension is paid), taking advantage of its absolute responsiveness to different devices.

**Back-End**: The BackEnd was developed in Java 8 using Spring Boot 2 (2.1.4), developed in Spring (very good support), taking advantage of the optimization of task automation resources, including their checks (eg the query of the existence of records)
The application will read the remote information from the lines and itineraries and they will persist when starting the server (Tomcat embedded). It can take a minute to popularize them.

**Database**: In principle use H2 (db in-memory) so that you can solve more specific development problems avoiding its configuration, only in the end it adapts to MySQL with its MySAM search engine which is used by Spring ( I think its default) to default the robustness it has.

In the application's application.properties the two bases were left as an option (including enabling the H2 console in case of need, for H2 its scope to runtime, currently under test, must also be changed in the POM)
