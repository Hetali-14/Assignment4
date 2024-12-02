
## Features
- **TestNG Configuration**: Uses a `testng.xml` file to organize test suites and classes.
- **API Testing**: Includes basic GET and POST requests with assertions to validate responses.
- **Temporary Solutions**: Implements basic tests as stopgap measures.
- **Technical Debt Documentation**: Highlights areas for improvement and plans to address them.
- **Best Practices**: Emphasizes isolating problematic code and maintaining clear documentation.


## Project Structure

```
src
└── test
    └── java
        └── com
            └── example
                └── api
                    └── ApiTest.java  // Test class with API test methods
pom.xml             // Maven dependencies for TestNG and RestAssured
testng.xml          // TestNG configuration file
README.md           // Project documentation
```

---

## Setup Instructions

1. **Prerequisites**
   - Install Java (JDK 8 or higher)
   - Install Maven
   - IDE (e.g., IntelliJ IDEA, Eclipse)

2. **Clone the Repository**
   ```bash
   git clone <repository-link>
   cd <repository-folder>
   ```

3. **Install Dependencies**
   Run the following command to install required Maven dependencies:
   ```bash
   mvn clean install
   ```

4. **Run Tests**
   Execute the tests using TestNG:
   ```bash
   mvn test
   ```

## Temporary Solutions

### Purpose
- The initial test implementations serve as temporary solutions to verify basic API functionality.
- Example: A test checks the status code of a GET request but does not validate the response body.

### Example
```java
@Test
public void testGetRequest() {
    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
    Assert.assertEquals(response.getStatusCode(), 200);
    // Temporary: Only verifying the status code
}
```

### Improvement Plan
- Add assertions to validate response content.
- Handle non-200 status codes.
- Implement data-driven testing for broader coverage.

## Reducing Technical Debt

### Steps Taken
1. Enhanced tests with additional assertions:
   ```java
   Assert.assertNotNull(response.getBody());
   Assert.assertTrue(response.getBody().asString().contains("userId"));
   ```
2. Created plans for further improvements (documented in comments).

## Problematic Code Isolation

### Example
A POST request test with known limitations:
```java
@Test
public void testPostRequest() {
    Response response = RestAssured.given()
        .contentType("application/json")
        .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
        .post("https://jsonplaceholder.typicode.com/posts");
    Assert.assertEquals(response.getStatusCode(), 201);
}
```

#### Known Issues:
- Occasional failures under high load.
- Limited validation of the response body.

## Best Practices

1. **Code Documentation**:  
   - Commented all known issues and improvement plans.  
2. **Source Control**:  
   - Ensure all changes are committed to GitHub.  
3. **Error Handling**:  
   - Focused on one issue per test improvement.  


## Future Improvements

1. **Enhanced Test Coverage**:  
   - Add more endpoints and scenarios (e.g., error codes).  
2. **Data-Driven Tests**:  
   - Use TestNG’s `@DataProvider` for testing multiple inputs.  
3. **Comprehensive Validations**:  
   - Validate the structure and content of the response body.  

## Repository Link

GitHub repository link:
[[GitHub Repository Link]](https://github.com/Hetali-14/Assignment4.git)
