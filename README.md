# DynamicSizes

[![](https://jitpack.io/v/MrNouri/DynamicSizes.svg)](https://jitpack.io/#MrNouri/DynamicSizes)

New size for support all of screen devices (MDP)

## Install library
* ### Gradle
Add jitpack.io to your root gradle file (project level) :
```
allprojects {
 	repositories {
 		...
 		maven { url 'https://jitpack.io' }
 	}
 }
 ```
 Add the dependency in your app build.gradle
 ```
dependencies {
   implementation 'com.github.MrNouri:DynamicSizes:1.0'
}
 ```
 
## Requirements
For use this library, you should use **```AndroidX```** instead of **```Support```**

## Usage

| Types | Values |
|---|:---:|
| Normal sizes  | mdp |
| Font size  | font_mdp |
| Negative sizes  | mines_mdp |

* #### Example
| Types | Values |
|---|:---:|
| Normal sizes  | ```_20mdp``` |
| Font size  | ```_12font_mdp``` |
| Negative sizes  | ```mines20mdp``` |