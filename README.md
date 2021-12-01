# Automation Project infrastructure 


## About

Automation infrastructure with a TestNG framework and a Page-Object-Model for testing applications on multiple platforms. The infrastructure provides an easy, simple and quick way to add new tests, and is easily expandable & maintained.

Jenkins is used to schedule executions of the Test Suites profiles for each platform  linked into a pipeline.

Allure Report system is used as the main reporting system.


## Overview

This project performs automated testing of various applications:
* Web based application
* Web API
* Mobile application
* Electron application
* Desktop application

### Infrastructure includes:

* Page object model design pattern
* External files Support
* Failure mechanisms
* Electron driver
* Reporting system (video recordings)
* API support
* Database support
* CI & CD support
* Support for different client browsers
* Automation Graphical elements support

### Applications tested:

* Grafana - Web based application tested with WebDriver
* Grafana API - Web API tested with REST Assuard
* UK Mortgage Calculator - Mobile application tested with Appium
* TodoList Desktop application tested with ElectronDriver
* Windows Calculator - Desktop application tested with WinAppDriver
## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install mvn.

```bash
pip install mvn
```
## Install

This is a [Node.js](https://nodejs.org/en/) module available through the
[npm registry](https://www.npmjs.com/).

Before installing, [download and install Node.js](https://nodejs.org/en/download/).
Node.js 0.6 or higher is required.

Installation is done using the
[`npm install` command](https://docs.npmjs.com/getting-started/installing-npm-packages-locally):

```sh
$ npm install mysql
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
