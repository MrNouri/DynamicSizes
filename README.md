# DynamicSizes

[![](https://jitpack.io/v/MrNouri/DynamicSizes.svg)](https://jitpack.io/#MrNouri/DynamicSizes)

New units of measure for support all of screen devices (MDP)<br>
With this library, you can support almost 97% of screens

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
## Library result
![MDP example](https://raw.githubusercontent.com/MrNouri/DynamicSizes/master/MDP_preview-min.jpg) 
 
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

* For see more examples and above images source codes, please see this link : [activity_main_mdp.xml](https://github.com/MrNouri/DynamicSizes/blob/master/app/src/main/res/layout/activity_main_mdp.xml)

## Thanks
Special thanks from [Mickael Guillaume](https://www.uplabs.com/guillaumemick) for this great [movie UI](https://www.uplabs.com/posts/movies-e0f9c1ea-a644-4666-857b-10933c4089ca)