Interactors —  These are the classes which actually contain your business logic code.
These are run in the background and communicate events to the upper layer using callbacks.
They are also called UseCases in some projects (probably a better name).
It is normal to have a lot of small Interactor classes in your projects that solve specific problems.
This conforms to the Single Responsibility Principle and in my opinion is easier on the brain.

Belong to Inner Layer