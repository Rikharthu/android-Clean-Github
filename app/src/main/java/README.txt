It is an android module that represents the presentation layer.

This package is responsible for everything rleated to showing things on the screen - it includes
the whole MVP stack (both the UI and Presenter packages, even though they belong to different layers)

Presenters in this layer are composed with interactors (use cases) that perform the job in a new
thread outside the main android UI thread, and come back using a callback with the data that will
be rendered in the view.