# itemDecoration

###### RecyclerView에서 아이템에 여백을 주는 방법이다.

###### MainActivity.java에서 ItemDecoration을 추가해준다.

```
recyclerview.addItemDecoration(IDecoration())
```

##### MyDecoration 클래스에서는 getItemOffsets을 재정의해 RecyclerView 안에 있는 아이템에 여백을 설정해 줄 수 있따.

```
class IDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets( outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(20,20,20,20)
    }
}
```

# clipToPadding

###### 스크롤이 가능한 뷰에서 해당 옵션을 사용할 수 있다.

###### RecyclerView 상단과 하단에 패딩이 있는 경우 패딩 공간을 사용하지 못하고 스크롤이 되는데 해당 옵션(clipToPadding="false")을 사용하면 그러한 패딩공간까지 사용하여 더 많은 아이템을 사용자에게 노출할 수 있다.

####### (참고)clipToPadding의 기본 값은 true이다.


