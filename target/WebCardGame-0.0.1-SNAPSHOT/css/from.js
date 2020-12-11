jQuery(function($){
//ユーザエージェント条件分岐
    var _ua = (function(){
    return {
    ltIE6:typeof window.addEventListener == "undefined" && typeof document.documentElement.style.maxHeight == "undefined",
    ltIE7:typeof window.addEventListener == "undefined" && typeof document.querySelectorAll == "undefined",
    ltIE8:typeof window.addEventListener == "undefined" && typeof document.getElementsByClassName == "undefined",
    ltIE9:document.uniqueID && typeof window.matchMedia == "undefined",
    gtIE10:document.uniqueID && window.matchMedia,
    Trident:document.uniqueID,
    Gecko:'MozAppearance' in document.documentElement.style,
    Presto:window.opera,
    Blink:window.chrome,
    Webkit:typeof window.chrome == "undefined" && 'WebkitAppearance' in document.documentElement.style,
    Touch:typeof document.ontouchstart != "undefined",
    Mobile:typeof window.orientation != "undefined",
    ltAd4_4:typeof window.orientation != "undefined" && typeof(EventSource) == "undefined",
    Pointer:window.navigator.pointerEnabled,
    MSPoniter:window.navigator.msPointerEnabled
    }
    })();
 
if(_ua.ltIE8){
 var card = $(".card");
    card.click(function(){
    if($(this).next().prop('checked')){
        $(this).next().attr("checked", false);
    }else{
        $(this).next().attr("checked", true);}
    });
}
});
$(function(){
  // 初期状態のボタンは無効
  $("#btn1").prop("disabled", true);
    // チェックボックスの状態が変わったら（クリックされたら）
    $("input[type='checkbox']").on('change', function () {
        // チェックされているチェックボックスの数
        if ($(".location_checkbox:checked").length > 0 || $(".nochange_checkbox:checked").length == 1) {
          $("#btn1").prop("disabled", false);
        } else {
          $("#btn1").prop("disabled", true);
        }
    });
});