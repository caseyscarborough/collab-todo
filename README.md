Collab-Todo Web Application
===========================

This application is a to-do application written in the Grails framework. It allows users to create and manage todos in categories. Users are also able to create buddy lists of other users of the application and can easily assign tasks to other users. It will also include reports and batch emails, along with some other functionality.

Dependencies
------------

- Java Development Kit
- Groovy 2.1.3
- Grails 2.2.2

Running the Application
-----------------------

Download the repository as a ZIP archive and extract it or clone the repository, then run the following from the command line:
```
grails run-app
```

You may also need to run a <code>grails upgrade</code> if you are using a newer version of Grails.

After running the application, navigate to http://localhost:8080/collab-todo in your browser.

Using the Application
---------------------

After running the application the application, you will be greeted with the welcome screen.

![alt text][screenshot1]

You may then proceed to login using the username: <code>casey</code> and the password: <code>password</code>. After logging in, you can look at, update, delete, or add new Categories, Users, or Todos. Sample data is created when the application is run to give an example of how the application works. More implementations are currently being worked on.

### Credits

This application is loosely based off of the application in the book Beginning Groovy, Grails and Griffon by Vishal Layka.

[screenshot1]: https://github.com/caseyscarborough/collab-todo/raw/master/img/main.png "The application's main layout."