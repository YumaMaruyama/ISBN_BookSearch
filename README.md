# SpringBoot_BookSearch
![iOS の画像 (5)](https://user-images.githubusercontent.com/83486993/149623996-9a392904-8266-490f-9b95-1b7ebaddfa12.png)


## [アプリ概要]
本に記載されてある13桁のINBNコードを入力すると本の詳細が確認できます。  
入力フォームにISBNコードを入力し検索すると、本の表紙や帯をみてもわからないような情報が確認できます。  
Google Books API v1を使用しました。
* アプリURL： http://133.167.92.108:8083/isbnSearchHome

## [使用技術]
* Java8
* HTML5
* CSS3
* spring boot 2.4.2
* thymeleaf 3.0.4
* bootstrap 4.2.1

## [動作環境]
* MariaDB 10.3.28
* apache 2.4.37

## [アプリ説明] ##

* アプリURL：http://133.167.92.108:8083/isbnSearchHome

1.URLにアクセスするとISBNコード検索画面が表示されます。
![スクリーンショット (44)-crop](https://user-images.githubusercontent.com/83486993/136874722-b4040428-09fd-46fe-b94f-f25bc0da794b.png)

2.ISBNコードを入力して検索すると、入力した本の情報が確認できます。
![スクリーンショット (45)-crop](https://user-images.githubusercontent.com/83486993/136874971-7988386f-a080-4e62-8805-2217e6a6ea95.png)
![スクリーンショット (46)-crop](https://user-images.githubusercontent.com/83486993/136874980-8f10f3c8-c724-4f91-a388-a9b407b200ff.png)

