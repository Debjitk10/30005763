## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


# Document and Case Management System

## Overview

This Java application provides a simple interface for managing documents, clients, and cases. It allows users to perform CRUD (Create, Read, Update, Delete) operations on these entities through a console-based menu system.

## Features

### Document Management:
- Upload, view, update, and delete documents.

### Client Management:
- Add, view, update, and delete client information.

### Case Management:
- Create new cases, view case details, update case information, and close cases.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- A SQL-compatible database (e.g., MySQL, PostgreSQL)
- Database schema with `document`, `client`, and `casetable` tables

## Database Schema

Ensure the following tables exist in your database:

### `document`:
Stores document details.
- Columns: `document_id`, `title`, `description`, `file_path`

### `client`:
Stores client information.
- Columns: `client_id`, `name`, `email`, `phone_number`, `address`

### `casetable`:
Stores case details.
- Columns: `case_id`, `title`, `description`, `client_id`, `status`, `open_date`, `close_date`

## Setup

### Database Configuration:
- Update the `DatabaseConnection` class with your database credentials.

### Compile and Run:
- Compile the Java files: `javac App.java`
- Run the application: `java App`

## Usage

### Document Management:
1. Upload New Document
2. View Document Details
3. Update Document Information
4. Delete Document

### Client Management:
1. Add New Client
2. View Client Details
3. Update Client Information
4. Delete Client

### Case Management:
1. Create New Case
2. View Case Details
3. Update Case Information
4. Close Case

## License

This project is licensed under the MIT License.
