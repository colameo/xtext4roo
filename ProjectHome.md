[Spring Roo](http://www.springsource.org/roo) usually uses Java source code plus annotations (@Roo...) as metadata to generate more Java code from. While this works great in many cases (for example for the entities of an application), you might discover that in some cases annotations are not expressive enough to describe the higher level abstractions you want to generate code from. Also, annotations have limited capabilities to refer to other code artefacts. For example, you can refer to classes, but not to fields or methods. In most cases you end up with String-typed annotation values hard to refactor.

So, if you develop Roo add-ons and you reach the limits of annotations, you probably want to use a little DSL instead to drive code generation. With [Xtext](http://www.eclipse.org/Xtext/), you easily can create your DSL. Also, it provides the ability to refer to nearly arbitrary Java artefacts from the DSL (see [here](http://www.eclipse.org/Xtext/documentation/1_0_1/xtext.html#jvmtypes)).

But Xtext runs in Eclipse or standalone ... What is missing in the scenario is the ability to run your Xtext DSL parser within Roo. Then, the user could edit his DSL files and Roo would immediately kick off parsing and code generation in the background.

The xtext4roo project provides an OSGi bundle that wraps Xtext to run within the Apache Felix Container of Spring Roo.

Furthermore, it allows for easy registration of Xtext DSLs within Spring Roo. After registration of your DSL, file monitoring for files with your DSL's suffix is enabled and you can easily write add-ons to get the parsed content of your DSL files and to generate code from.


Please see the following instructions:

  * [Install](InstallXtext4Roo.md)
  * [Try the example DSL](TryingTheExampleDSL.md)
  * [Enable your own DSL for Roo](EnablingYourDSLforRoo.md)


Please note that this is a prototype. Although it works in general, it is not complete. For instance, you might miss the following:
  * binary distribution in some OBR
  * bundle signature and registration for use with RooBot for easy installation
  * granular OSGi bundles instead of a big one
