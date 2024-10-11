# Spring Boot Base64 Zip Converter

## Overview

The Spring Boot Base64 Zip Converter is a Java-based application designed to facilitate the conversion of Zip files to Base64 strings and vice versa. This tool streamlines file handling, making it easier to transmit binary data in a text format suitable for various applications and protocols.

## Features

- **Convert Zip files to Base64 strings**: Users can upload a Zip file, and the application will return its Base64 encoded representation
- **Convert Base64 strings to Zip files**: Users can provide a Base64 string, and the application will return the corresponding Zip file for download

## Prerequisites

To run this application, ensure that you have the following installed:

- **JDK**: version 1.8 or higher
- **Maven**: version 3.6 or higher
- **Spring Boot**: version 2.x

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <project-directory>
   ```
   
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Usage

### Convert Zip File to Base64 String

- Endpoint: `POST /convert/zip-to-base64`
- Request: The request should include the Zip file as a multipart file
- Response: A Base64 encoded string

Example Request:

```http
POST /convert/zip-to-base64 HTTP/1.1
Content-Type: multipart/form-data

<Zip file content>
```

### Convert Base64 String to Zip File

- Endpoint: `POST /convert/base64-to-zip`
- Request: The request body should contain the Base64 string
- Response: A downloadable Zip file

Example Request:

```http
POST /convert/base64-to-zip HTTP/1.1
Content-Type: text/plain

<Base64 string>
```

## Important Notes

- Ensure that the uploaded file size does not exceed the server's configured limits (default 10MB)
- Validate that the Base64 string is properly formatted to avoid errors during conversion

## Contribution

Contributions are welcome! Please feel free to submit issues or pull requests to enhance the functionality or performance of the application.

## Disclaimer
This project is intended for educational and research purposes only. Users should ensure compliance with all applicable laws and regulations when utilizing this software.
