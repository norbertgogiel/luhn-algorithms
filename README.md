# Luhn Algorithms

Modulus-10 algorithms for validation and generation

[![CI](http://github.com/vangogiel/luhn-algorithms/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/vangogiel/luhn-algorithms/actions/workflows/build.yml)
[![License](http://img.shields.io/badge/License-Apache%202.0-brightgreen.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](http://maven-badges.herokuapp.com/maven-central/com.vangogiel.luhnalgorithms/luhn-algorithms/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.vangogiel.luhnalgorithms/luhn-algorithms)

This is a simple library utilising core Java for Modulus-10 algorithms. You can simply validate a number if provided as `long` or `String`. The latter is parsed into `long` primitive. You can also generate your own valid Luhn number,
which is returned as `long`.

## Dependency

##### Maven

```xml

<dependency>
    <groupId>com.vangogiel.luhnalgorithms</groupId>
    <artifactId>luhn-algorithms</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### Gradle

```groovy
dependencies {
    implementation 'com.vangogiel.luhnalgorithms:luhn-algorithms:1.0.0'
}
```

## Usage

```java
// Validation
LuhnAlgorithms.isValid(4716881992809921L) // Valid Luhn

LuhnAlgorithms.isValid(4716881992809922L) // Invalid Luhn

LuhnAlgorithms.isValid("4716881992809921") // Valid Luhn

LuhnAlgorithms.isValid("4716881992809922") // Invalid Luhn

// Generation
LuhnAlgorithms.generateLuhnFromRange(111, 2, 5); // Returns for example 14233

LuhnAlgorithms.generateRandomLuhn(6); // Returns for example 136820
```

## Versioning

[Semantic Versioning](http://semver.org/) is used for versioning. 

## Changelog

For a complete list of changes, and how to migrate between major versions, see [release page](https://github.com/vangogiel/luhn-algorithms/releases). 

## License
Copyright (C) 2021 Vangogiel - Norbert Gogiel
Licensed under the Apache License, Version 2.0