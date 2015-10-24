Xtext4roo comes as one big OSGi bundle called xtext4roo-wrapper, which wraps:

  * Xtext
  * EMF
  * Google Guice
  * Antlr
  * other Xtext dependencies

Additional, it contains classes that allow to integrate Xtext DSLs into Roo.

The folowing steps describe how to install the xtext4roo-wrapper into your Sping Roo Shell:

  1. checkout the source into some directory of your choice:
```
svn checkout http://xtext4roo.googlecode.com/svn/trunk/
```
  1. in trunk/xtext4Roo build the project with Maven (3.0 or above):
```
mvn install
```
  1. in trunk/xtext4Roo/xtext4roo-wrapper/target, you should now have the jar of the xtext4roo-wrapper bundle
  1. start Spring Roo Shell and install the bundle:
```
osgi install --url file:///{absolute path of xtext4roo-wrapper bundle jar}
osgi framework command start {bundle id of  xtext4roo-wrapper bundle}
```
  1. verify the bundle has been activated:
```
osgi ps
```