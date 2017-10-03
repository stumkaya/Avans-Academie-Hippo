# Avans Academie

## Prerequisites
In order to use the gulp based front-end development environment you need to have [npm (version 3 or later)][1] installed.

## Installation
To start using the system you'll first need to install it's dependencies by starting a command prompt/terminal and running the following command:

> $ npm install

Once the npm package manager has finished installing all packages you're able to use gulp in order to build and/or serve the front-end environment. For gulp the following command are available:

> $ gulp build

This command transpiles all sources available within the _src_ folder into a _dist_ folder. Be aware that running this command will first clear the existing build folder in order to make sure there is a clean build available. The build process runs several tasks in parallel for which the sources and their destination are defined within the _common.js_ file located in the _gulp_ folder. 

> $ gulp serve

The serve command will start an instance of _Browser Sync_ to serve the contents of the _dist_ folder. By default it will become available at [http://localhost:3000][2] but you can check the command prompt/terminal for the exact URL. The serve command will automatically watch for file changes within _html_, _scss_, _css_, and _javascript_ files and automatically re-build those files and reload your browser.
Please be aware that newly created files, while serving the solution, will **not** automatically be copied to the dist folder. This unfortunately is not part of gulp's watch process and when doing so a build will have to be done. 

> $ gulp help

Some help will be shown regarding the available gulp commands.

## HTML includes
For using HTML includes, to avoid duplication of page headers and footers for example, the npm package _gulp-file-include_ has been added to the solution. This package allows you to include HTML files. The syntax for adding a HTML include is:

> @@include('./inc/_myinclude.html');

Please not that the include file start with an underscore, this prevents the build system from copying those files as separate HTML files to the _dist_ folder. In addition generic includes are placed within an _inc_ folder under the root of the _src_ folder. The usage of the _inc_ folder is however not mandatory. The path specified as part of the include is relative to the document in which it is used.

## Content devision

This document describes the front-end design for Avans Academie. The designs as provided are devided into pages
and components. Pages are used to define sets of components that make up know content pages (such as 
'opleiding'), but in theory components are not page dependant and can be placed on any page. Every component 
will be responsible for specifying the free space it needs to the bottom and to the right.

## Homepage

### Header / banner 
Full screen header/banner for the homepage, supports video background with an image fallback. 

### Link list component
A component that shows a title and a list of links. The component supports col-6.

### YouTube components
An embeded YouTube implementation. The component supports col-6.

### Stream component
A list of news items, newest item on the left. If an event is upcoming the first item will be the event. This
component uses the full page width.


## Opleidingen

### Opleidingen component
The component consists of a title, an introduction, and a list of 'cards'. Each card represents an 'opleiding'.

### Opleiding component
A 'card' style component that represents an 'opleiding'. It consists of an image and a title.


## Opleiding

### Header / banner
A full width banner that keeps the aspect ratio of the background image. The header consists of a title, 
sub-title, quote, call-to-action, link list, and an image.

### Content component
The content component will be used with a rich text editor. A content component consists of a title, chapeau, 
and the main content (rich text). Be aware that rich content also includes a styled bullet list.

### Widget component
A simple widget that has a title, and content. The content consists of a title, sub-title, body text, and link
list. The individual widgets are also styled in different ways.

### Image slider component
A full width image carousel, the images are skewed and there will be an animation effect for sliding.

### Tabbed content component
Tabbed content is represented by multiple content components which are encapsulated within a tabbed content 
component. The tabbed content consists of a title, chapeau, list of content items. A content item being a
content component. Each item within the tabbed content component will have an anchor link which can be used
to directly link to its content.

### Multi column content component
Identical to the content component. The multi column content component allows for the number of columns to be
specified.

### Info holder component
The info holder component consists of a title, chapeau, description, and a list of 'cards'. Each card represents
an info component.

### Info component
A 'card' style component that consists of a title, body text, image, and link. If an image is provided then 
the card will be displayed in a different style.

### Social component
A component that displays social sharing icons.


## Kiezen voor een AD

### Content component
Already described.

### YouTube component
Already described. In addition the YouTube component will allow for a title.

### Details component
The details component consists of a title, chapeau, description, and a list of 'cards'. Each card represents a 
detail component.

### Detail component
A detail component has a title, level, duration, educational type, and a list of details. The list of details
will be represented as a styled un-ordered list.


## Praktische informatie

### Info holder component
Already described.

### Info component
Already described.


## Praktische informatie item

### Content component
Already described.

### Widget component
Already described.

### Social component
Already described.


## Praktische informatie locatie

### Google Maps banner
A full width banner that keeps its aspect ratio. The header consists of a title, 
sub-title, location details, Google Maps details.

### Content component (left)
Already described.

### Content component (right)
Already described.

### Facilities component
The facilities component consists of a title, chapeau, description, and a list of 'cards'. Each card represents a 
facility component.

### Facility component
A facility component consists of an image, title, and description.