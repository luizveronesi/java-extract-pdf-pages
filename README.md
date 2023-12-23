# Spring Extract PDF pages

Java implementation to extract all pages from pdf files and convert to jpg images.

## Installation

```bash
# Clone the repository
git https://github.com/luizveronesi/spring-extract-pdf-pages.git

# Navigate to the project directory
cd spring-extract-pdf-pages

# Install dependencies
mvn install
```

```bash
# Docker installation
mvn clean package -f pom.xml -U
docker build . -t spring-extract-pdf-pages-example:latest
docker create --name spring-extract-pdf-pages-example --network your-network --ip x.x.x.x --restart unless-stopped spring-extract-pdf-pages-example:latest bash
docker start tycho-sentence
```

## Usage

```bash
# Run the application
java -jar target/api.jar
```

Open Swagger: http://localhost:8080/swagger-ui/index.html

## Configuration

You can change the max file size at scr/main/resources/application.properties

## Endpoint

### POST /

Upload a file and extract the pages.

| Parameter |     Type      | Description                          |
| --------: | :-----------: | ------------------------------------ |
|  `folder` |    string     | The output folder for the jpg files. |
|    `file` | MultipartFile | The file itself.                     |

## Next steps

Implement unit tests.
