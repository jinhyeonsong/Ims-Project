let $footer = null;
const $window =  $(window);
let $body = null;

$(function() {

	$footer = $("#footer");
	$body = $("body");
 
	$(window).resize(fixFooter);

	fixFooter();
 
});

function fixFooter() {
	
	console.log("리사이즈됨!");
	
    const wHeight = $window.height();
    let bHeight = parseInt($body.height());
    
    console.log(wHeight);
    console.log(bHeight);

    if($footer.hasClass("fixed")) {
        bHeight += 100;
    }

    if(wHeight>=bHeight) {
        $footer.addClass("fixed");
    }else {
        $footer.removeClass("fixed");
    }
}

