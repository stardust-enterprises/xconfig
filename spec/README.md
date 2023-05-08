# xconfig specification

This document describes the **xconfig** structure and exchange flow between its 3 main components.

## Table of contents

- [xconfig specification](#xconfig-specification)
  - [Table of contents](#table-of-contents)
  - [Frontend](#frontend)
    - [Frontend flow](#frontend-flow)
  - [Backend](#backend)
    - [Backend flow](#backend-flow)
  - [Middle-end](#middle-end)
    - [Middle-end flow](#middle-end-flow)
  - [Example](#example)
  - [License](#license)

## Frontend

The frontend is the part of the configuration that is user-interactable. It is the part that allows for configuration view and/or modification.

At its core, while a frontend is mostly imagined as a graphical user interface, it can be anything that allows for interaction with the configuration, i.e a CLI application for example.

### Frontend flow

The frontend service must be implemented with the [`enterprises.stardust.xconfig.frontend.Frontend`](../frontend/src/main/java/enterprises/stardust/xconfig/frontend/Frontend.java) 
interface and be exposed via the Java [ServiceLoader API](https://docs.oracle.com/javase/8/docs/api/java/util/ServiceLoader.html).

The frontend service will utilize the backend service(s) as well as the middle-end service(s) to provide a user interface for configuration modification.

## Backend

The backend is

### Backend flow

The backend service must be implemented with the [`enterprises.stardust.xconfig.backend.Backend`](../backend/src/main/java/enterprises/stardust/xconfig/backend/Backend.java)
interface and be exposed via the Java [ServiceLoader API](https://docs.oracle.com/javase/8/docs/api/java/util/ServiceLoader.html).

## Middle-end

The middle-end is the part of the configuration that is programmer-interactable. It is the part that allows for configuration declaration and (sometimes) validation.

A middle-end service can be seen as a collection of middle serializers, paired with frontend-facing instructions, such as rendering styles or dependency information.
                                    
**writing note**: This means that color can = 3 ints basically

### Middle-end flow

The middle-end service will provide proxy methods to the backend service(s) for easier access for developers.

