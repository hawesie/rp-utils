# Utilities for Robot Programming 

This repository provides code missing from `java.util` in leJOS under via th `rp.util` package. Most of the source for this was copied directly from the Java source and the rights remain with Java.

## Getting the code

To use this code in your project you first need to clone the project into your Eclipse workspace. The following assumes you use the directory `~/workspace` as your Eclipse workspace as it is the default value. If this is not true, then replace this directory with the correct one for you. 

1. Open a terminal
2. Change into your workspace directory: `cd ~/workspace`
3. Clone this project using Git: `git clone https://github.com/hawesie/rp-utils`
4. In Eclipse, create a new leJOS NXT project with the name `rp-utils`. This should automatically find the sources you just cloned. You could also create a leJOS PC or standard Java project for this code, but using a leJOS NXT project ensures that this code should run on the robot too.

## Using the code

You should develop your own code in a *separate project* to `rp-utils` as this will allow you to easily update the provided code if necessary. To do this, use the `Java Build Path` entry in your other project's properties, and `Add...` the `rp-utils` project under the `Projects` tab.

## Fixing bugs

If you find any bugs in my code, please open an [issue](https://github.com/hawesie/rp-utils/issues) or create a pull request with the fix.
