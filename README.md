# Luhn Algorithms

Modulus-10 algorithms for validation and generation

[![CI](https://github.com/vangogiel/luhn-algorithms/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/vangogiel/luhn-algorithms/actions/workflows/build.yml)
[![License](https://img.shields.io/badge/License-Apache%202.0-brightgreen.svg)](https://opensource.org/licenses/Apache-2.0)

This is a simple library utilising core Java for Modulus-10 algorithms. You can simply validate a number if provided as `long` or `String`. The latter is parsed into `long` primitive. You can also generate your own valid Luhn number,
which is returned as `long`.

## Dependency

##### Maven

```xml

<dependency>
    <groupId>com.vangogiel.luhnalgorithms</groupId>
    <artifactId>luhn-algorithms</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

#### Gradle

```groovy
dependencies {
    implementation 'com.vangogiel.luhnalgorithms:luhn-algorithms:1.0.0-SNAPSHOT'
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
