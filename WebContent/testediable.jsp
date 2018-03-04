<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<html>  
    <head>  
        <title>Table Test Demo</title>  
        <style>  
            .view_table {  
                width:800px;  
                height:auto;  
                margin:0px auto;  
            }  
              
            .view_table table {  
                width: 100%;  
                font-size: 12px;  
                font-family: "Microsoft YaHei" !important;  
                text-align: center;  
            }  
              
            .view_table table tr td {  
                border: 1px green solid;  
                background-color: #cccccc;  
                line-height: 30px;  
                width: 80px;  
            }  
        </style>  
    </head>  
    <body>  
        <div class="view_table" name="viewTab">  
            <table border="0" cellpadding="0" cellspacing="0">  
                <tr>  
                    <td>1</td>  
                    <td>2</td>  
                    <td>3</td>  
                    <td>4</td>  
                    <td><input type="button" value="edit"></td>  
                </tr>  
                <tr>  
                    <td>1</td>  
                    <td>2</td>  
                    <td>3</td>  
                    <td>4</td>  
                    <td><input type="button" value="edit"></td>  
                </tr>  
                <tr>  
                    <td>1</td>  
                    <td>2</td>  
                    <td>3</td>  
                    <td>4</td>  
                    <td><input type="button" value="edit"></td>  
                </tr>  
            </table>  
        </div>  
    </body>  
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>  
    <script>  
        (function(){  
            $('input[type="button"]').on('click', function(){  
                var $this = $(this),  
                    edit_status = $this.attr('edit_status'),  
                    status_value = edit_status && 1 == edit_status ? 0 : 1,  
                    $td_arr = $this.parent().prevAll('td');  
                $this.val(1 == status_value ? '完成' : '修改').attr('edit_status', status_value);  
                $.each($td_arr, function(){  
                    var $td = $(this);  
                    if(1 == status_value) {  
                        $td.html('<input type="text" value="'+$td.html()+'">');  
                    } else if(0 == status_value){  
                        $td.html($td.find('input[type=text]').val());  
                    }  
                });  
            });  
        })();  
    </script>  
</html>  

</body>
</html>