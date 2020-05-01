# startActivityForResult()
###### Activity의 결과를 받으려면 호출할 때 startActivity() 대신 startActivityForResult() 메소드를 사용해야 합니다. 
###### 새로 호출된 Activity에서는 setResult()를 통해 돌려줄 결과를 저장하고 finish()로 Activity를 종료합니다. 
###### 이후 그 결과는 호출했던 Activity의 onActivityResult() 메소드를 통해 전달되게 됩니다.

### 1. startActivityForResult()로 Activity 호출하기
###### 기존에 startActivity()로 호출하던 것을 startActivityForResult()로 호출을 하면서 인수를 하나 추가해 줍니다. 
###### 이 인수는 0보다 크거나 같은 integer 값으로 추후 onActivityResult() 메소드에도 동일한 값이 전달되며 이를 통해 하나의 onActivityResult() 메소드에서 (만약 있다면) 여러 개의 startActivityForResult()를 구분할 수 있습니다. 

### 2. 호출된 Activity에서 setResult()로 결과 돌려주기
###### 호출된 Activity에서 setResult() 메소드로 결과를 저장할 수 있습니다. 이 때 성공인 경우는 RESULT_OK로 실패라면 RESULT_CANCEL을 설정할 수 있습니다. (두 값 모두 Activity의 멤버 변수입니다.)
###### 이후 finish() 메소드로 Activity를 종료합니다.

### 3. onActivityResult()에서 결과 확인하기
###### 안드로이드에서는 onActivityResult() 메소드를 통해 호출된 Activity에서 저장한 결과를 돌려줍니다. 
###### 이 때 requestCode는 처음 startActivityForResult()의 두번째 인수 값이며, resultCode는 호출된 Activity에서 설정한 성공(RESULT_OK)/실패(RESULT_CANCEL) 값입니다. 이를 통해 어떤 호출 (REQUST_TEST) 이었는지와 결과가 어떠한지 (RESULT_OK)를 알 수 있으므로 그에 맞는 동작을 진행할 수 있습니다. 마지막으로 세번째 인수 Intent는 호출된 Activity에서 저장한 결과입니다.
