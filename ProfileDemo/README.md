# Profile

Profiles allow you to use different configurations for different environments without changing your Java code.

For example, while developing an application, you might use a local `MySQL` database. In production, you might use a cloud database with different credentials.

Instead of manually changing application.properties every time, you can create separate profiles.

Common profiles are:
- dev — Development environment
- test — Testing environment
- prod — Production environment


## How to create profiles

We can create different profiles using file name like `application-{profile}.properties`

Ex : 
- application-dev.properties
- application-stage.properties
- application-prod.properties

And we also have one common file `application.properties`. This file have common setting.

### Note: Spring first read common `application.properties` and then specified profile file.

## How to set or run code using specific profile 

In application.properties we set `spring.profiles.active={profile}` 

or 

We can run using command in terminal 

`./mvnw.cmd spring.boot:run "-Dspring-boot.run.profile={profile}"`

This cmd uses maven wrapper


### Note: `application.properties` and `application.yml`, if both are present in project then application.properties get priority over application.yml file 