## CollapsibleListView

### Android library to add a list view which can collapse or expand.

### Usage

#### Adding collapsiblelistview module in your app

##### In app/build.gradle
```
    dependencies {
        compile project(':collapsiblelistview')
    }
```

#### Create a CollapsibleList in app

##### In your activity file

```
    CollapsibleList collapsibleList = new CollapsibleList();

```

#### Adding a bitmap and string for a entry(some work needed in future to draw custom elements)

```
    collapsibleList.addCollapsible(title,bitmap);
```

#### Showing the collapsibleList

```
    collapsibleList.show();
```


### Screencast of demo

<img src="https://github.com/Anwesh43/CollapsibleListView/blob/master/screencast/collapsiblelistview.gif" alt="screencast of demo" width="300px" height="500px">
