$(document).ready(() => {
    $( ".change" ).click(() => {
        if( $( "body" ).hasClass( "bg-dark text-success" )) {
            $( "body,.card" ).removeClass( "bg-dark text-success" );
            $( ".change" ).text("DARK MODE")
        } else {
            $( "body,.card" ).addClass( "bg-dark text-success" );
            $( ".change" ).text("LIGHT MODE")
        }
    });
    $("#subBtn").click(() =>{
        amount= $("#amount").val()
        rate= $("#rate").val()
        time= $("#time").val()
        interest = (amount * (rate * 0.01)) / time;
        emi = ((amount / time) + interest).toFixed(2);
        $("#emi").val(emi);
        $("#total").val(emi*time);
    });
});