$(function () {
    $(window).scroll(function () {
        if ($(window).scrollTop() >= $(document).height() * 0.9) {
            console.log("------");
        }
    });
});


// function ajaxRead() {
    //     // var html="";
    //     //$("my_list_li1").value = "ajaxRead";
    //     $.ajax({
    //         // type:'get',
    //         // dataType:'jsonp',
    //         // url:'http://api.flickr.com/services/feeds/photos_public.gne?tags=car&tagmode=any&format=json&jsoncallback=?',
    //         beforeSend:function(){console.log('loading...')},
    //         success:function(data){
    //             // $.each(data.items,function(i,item){
    //             //     html+='<div class="box">';
    //             //     html+='<h1>'+item.title+'</h1>';
    //             //     html+='<a hreft="'+item.link+'"><img src="'+item.media.m+'"/></a>'
    //             //     html+='<div>'+item.tags+'</div>';
    //             //     html+='</div>';
    //             // });
    //         // $("#resText").append($(html));
    //         },
    //         complete:function(){console.log('mission acomplete.')}
    //     });
    // }
