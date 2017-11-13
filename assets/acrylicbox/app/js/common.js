$(function() {

	$("form").submit(function() { //Change
	var th = $(this);
	$.ajax({
		type: "POST",
			url: "mail.php", //Change
			data: th.serialize()
		}).done(function() {

			swal("Спасибо за оставленную заявку!", "Наш менеджер свяжется с вами в ближайшее время.", "success");
			yaCounter46040844.reachGoal('ORDER');

			setTimeout(function() {
				// Done Functions
				th.trigger("reset");
			}, 1000);
			if($('.orderform').find('h3').html()=== 'Скачать каталог')
			{
				document.location.href = 'http://acrylicbox.ru/catalog.pdf';
			}
		});
		return false;
	});

	$('.popup_btn').magnificPopup({
		// type: 'inline',
		items: {
	       src: '#ordermodal',
	       type: 'inline'
   		},
		fixedBgPos: true,

		overflowY: 'auto',
		// modal: true,

		closeBtnInside: true,
		preloader: false,
		fixedContentPos: true,

		// closeOnContentClick: true,

		midClick: true,
		removalDelay: 300,
		mainClass: 'my-mfp-zoom-in',
		callbacks: {
		    open: function() {
		      // Will fire when this exact popup is opened
		      // this - is Magnific Popup object
		    },
		    close: function() {
		      // Will fire when popup is closed
		    }
		    // e.t.c.
		  }
	});
	$(".scroll-btn").click(function(){
            var selected = $(this).attr('href');	
            $.scrollTo(selected, 500);
            $('.hamburger').removeClass('is-active');
            $('#navigation').removeClass('is-active');
            $('.mfp-bg1').addClass('hidden');
            return false;
        });
	$('.hamburger').click(function(){
        $(this).toggleClass('is-active');
        $('#navigation').toggleClass('is-active');
        $('.mfp-bg1').toggleClass('hidden');
    });
     $('.mfp-bg1').click(function(){
        $('.hamburger').toggleClass('is-active');
        $('#navigation').toggleClass('is-active');
        $('.mfp-bg1').toggleClass('hidden');
    });
     $('.slider1').slick({
        dots: true,
        autoplay: true,
        autoplaySpeed: 3500,
        mobileFirst: true,
        adaptiveHeight:true
    });	
     $('.gallery').magnificPopup({
      delegate: 'a',
      type: 'image',
      tLoading: 'Loading image #%curr%...',
      mainClass: 'mfp-img-mobile',
      gallery: {
         enabled: true,
         navigateByImgClick: true,
			preload: [0,1] // Will preload 0 - before current, and 1 after the current image
		},
		image: {
			tError: '<a href="%url%">The image #%curr%</a> could not be loaded.',
			titleSrc: function(item) {
				return item.el.attr('title') + '<small>FLORIST-MARKET Товары для флористов</small>';
			}
		}
	});
     $('#phone').mask("+7 (999) 999-99-99");
     $('.phone').mask("+7 (999) 999-99-99");
     var form = $("#example-form");
		form.validate({
		    errorPlacement: function errorPlacement(error, element) { element.before(error); },
		    messages: {
				name1: {
				required: "Это поле обязательно для заполнения"
				},
				phone1: {
				required: "Укажите ваш телефон"
				}

				}
		});
		form.children("div").steps({
		    headerTag: "h3",
		    bodyTag: "section",
		    transitionEffect: "slideLeft",
		    forceMoveForward: true,
		    onStepChanging: function (event, currentIndex, newIndex)
		    {
		        form.validate().settings.ignore = ":disabled,:hidden";
		        if(form.valid()) $('.num').find('span').html(newIndex+1);
		        return form.valid();
		    },
		    onFinishing: function (event, currentIndex)
		    {
		        form.validate().settings.ignore = ":disabled";
		        if(form.valid()) $('.num').html('Форма заполнена');
		        return form.valid();
		    },
		    onFinished: function (event, currentIndex)
		    {
		         // var form = $(this);

           //      // Submit form input
                form.submit();
                form.find('.calcform_end').empty().html('<div class="h3_title">Форма отправлена</div>');
		    },
		    labels: {
		        cancel: "Назад",
		        current: "current step:",
		        pagination: "Pagination",
		        finish: "Отправить заявку",
		        next: "Далее",
		        previous: "Назад",
		        loading: "Загрузка ..."
		    }
		});
     $('.gallery1').slick({
      infinite: true,
      slidesToShow: 3,
      slidesToScroll: 2,
      autoplay: true,
      centerMode: true,
      centerPadding: '165px',
      responsive: [
      {
          breakpoint: 1200,
          settings: {
            slidesToShow: 3,
            slidesToScroll: 3,
            infinite: true,
            dots: true
        }
    },
    {
      breakpoint: 480,
      settings: {
        centerMode: false,
        slidesToShow: 2,
        slidesToScroll: 2
    }
}
    // You can unslick at a given breakpoint now by adding:
    // settings: "unslick"
    // instead of a settings object
    ]
});
 //    $('.gallery').magnificPopup({
 //      delegate: 'a',
 //      type: 'image',
 //      tLoading: 'Loading image #%curr%...',
 //      mainClass: 'mfp-img-mobile',
 //      gallery: {
 //         enabled: true,
 //         navigateByImgClick: true,
	// 		preload: [0,1] // Will preload 0 - before current, and 1 after the current image
	// 	},
	// 	image: {
	// 		tError: '<a href="%url%">The image #%curr%</a> could not be loaded.',
	// 		titleSrc: function(item) {
	// 			return item.el.attr('title') + '<small>Мобильные бани Муромец</small>';
	// 		}
	// 	}
	// });


});

function popup(type){
			 switch(type){
			    case 'callback':
			    var h1 = 'Заказать звонок';
			    var h2 = 'Оставьте заявку, наш менеджер<br>свяжется с вами и ответит на интересующие вопросы.';
			    var btn = 'Заказать звонок';
			    break;
			    case 'question':
			    var h1 = 'Получить консультацию';
			    var h2 = 'Наш менеджер свяжется с вами и ответит на интересующие вас вопросы.';
			    var btn = 'Получить консультацию';
			    break;
			    
			    case 'calc9':
			    var h1 = 'Заказать боксы под 9 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc15':
			    var h1 = 'Заказать боксы под 15 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc21':
			   var h1 = 'Заказать боксы под 21 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc25':
			    var h1 = 'Заказать боксы под 25 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc35':
			    var h1 = 'Заказать боксы под 35 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc49':
			    var h1 = 'Заказать боксы под 49 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc75':
			    var h1 = 'Заказать боксы под 75 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc81':
			    var h1 = 'Заказать боксы под 81 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc91':
			    var h1 = 'Заказать боксы под 91 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc101':
			    var h1 = 'Заказать боксы под 101 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc121':
			    var h1 = 'Заказать боксы под 121 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc143':
			    var h1 = 'Заказать боксы под 143 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc169':
			    var h1 = 'Заказать боксы под 169 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc195':
			    var h1 = 'Заказать боксы под 195 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'calc225':
			    var h1 = 'Заказать боксы под 225 роз';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'rose1':
			    var h1 = 'Заказать боксы под 1 розу(высокие)';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'rose2':
			     var h1 = 'Заказать боксы под 1 розу(стандарт)';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'rose3':
			     var h1 = 'Заказать боксы под 1 розу(квадратная)';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'rose4':
			     var h1 = 'Заказать боксы под 1 розу';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами, уточнит нужное количество и информацию по доставке.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'individual':
			    var h1 = 'Сформировать индивидуальный заказ';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами и уточнит количество, нужных вам позиций.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'test':
			    var h1 = 'Заказать тестовый набор на 9 и 25 цветков';
			    var h2 = 'Оставьте заявку, наш менеджер свяжется с вами и уточнит детали заказа.';
			    var btn = 'Оставить заявку';
			    break;
			    case 'consult':
			    var h1 = 'Получить консультацию';
			    var h2 = 'Наш менеджер свяжется с вами и ответит на интересующие вас вопросы.';
			    var btn = 'Получить консультацию';
			    break;
			    case 'download':
			    var h1 = 'Скачать каталог';
			    var h2 = 'Оставьте ваши контакты, и мы отправим вам полный каталог нашей продукции с ценами и скидочной программой.';
			    var btn = 'Получить консультацию';
			    break;
			    default:
			    var h1 = 'Оставить заявку';
			    var h2 = 'Наш менеджер свяжется с вами и ответит на интересующие вас вопросы.';
			    var btn = 'Оставить заявку';
			    break;
			}
			// $(".orderform").attr("checked", false);	
			$('.orderform').find('h3').html(h1);
			$('.orderform').find('.h4').html(h2);
			// $('.orderform').find('p').html(h2);
			$('.orderform').find('.btn').attr("value", btn);
			$('.orderform').find('.formtype').attr("value", h1);
			// $('.orderform').find('.formtype').attr("value", h1);
			$('.ordermodal').magnificPopup('open');
			//popup_text('popup1');
}