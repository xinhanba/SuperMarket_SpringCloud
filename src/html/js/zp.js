/****************************************************
 *	 Author :	xuyw					            *
 *	 Version:   v1.0								*
 *   Email  :   xyw10000@163.com                    *
 ****************************************************/

function randomnum(smin, smax) { // 获取2个值之间的随机数
  var Range = smax - smin;
  var Rand = Math.random();
  return (smin + Math.round(Rand * Range));
}

function runzp() {
  // var data = '[{"id":1,"prize":"1BTC","v":1.0},{"id":2,"prize":"0.5BTC","v":2.0},{"id":3,"prize":"0.1BTC","v":3.0},{"id":4,"prize":"0.05BTC","v":4.0},{"id":5,"prize":"0.01BTC","v":5.0},{"id":6,"prize":"0.005BTC","v":6.0},{"id":7,"prize":"0.001BTC","v":7.0}]'; // 奖项json
  // var obj = eval('(' + data + ')');
  // var result = randomnum(1, 100);
  // var line = 0;
  // var temp = 0;
  // var returnobj = "0";
  // var index = 0;

  // //alert("随机数"+result);
  // for (var i = 0; i < obj.length; i++) {
  //   var obj2 = obj[i];
  //   var c = parseFloat(obj2.v);
  //   temp = temp + c;
  //   line = 100 - temp;
  //   if (c != 0) {
  //     if (result > line && result <= (line + c)) {
  //       index = i;
  //       // alert(i+"中奖"+line+"<result"+"<="+(line + c));
  //       returnobj = obj2;
  //       break;
  //     }
  //   }
  // }
  // var angle = 360;
  // var message = "";
  // var myreturn = new Object;
  // if (returnobj != "0") { // 有奖
  //   // message = "恭喜中奖了";
  //   var angle0 = [0, 45];
  //   var angle1 = [46, 90];
  //   var angle2 = [91, 135];
  //   var angle3 = [136, 180];
  //   var angle4 = [181, 225];
  //   var angle5 = [226, 270];
  //   var angle6 = [271, 315];
  //   var angle7 = [271, 315];
  //   switch (index) {
  //     case 0: // 一等奖
  //       var r0 = randomnum(angle0[0], angle0[1]);
  //       angle = r0;
  //       break;

  //     case 1: // 二等奖
  //       var r1 = randomnum(angle1[0], angle1[1]);
  //       angle = r1;
  //       break;

  //     case 2: // 三等奖
  //       var r2 = randomnum(angle2[0], angle2[1]);
  //       angle = r2;
  //       break;

  //     case 3: // 三等奖
  //       var r3 = randomnum(angle3[0], angle3[1]);
  //       angle = r3;
  //       break;

  //       case 4: // 三等奖
  //       var r4 = randomnum(angle4[0], angle4[1]);
  //       angle = r4;
  //       break;

  //       case 5: // 三等奖
  //       var r5 = randomnum(angle5[0], angle5[1]);
  //       angle = r5;
  //       break;
  //       case 6: // 三等奖
  //       var r6 = randomnum(angle6[0], angle6[1]);
  //       angle = r6;
  //       break;
  //       case 7: // 三等奖
  //       var r7 = randomnum(angle7[0], angle7[1]);
  //       angle = r7;
  //       break;

  //   }
  //   myreturn.prize = returnobj.prize;
  // } 
  // else { // 没有
  //   // // message = "再接再厉";
  //   // var angle3 = [316, 360];
  //   // var angle4 = [197, 220];
  //   // var angle5 = [259, 340];
  //   // var r = randomnum(3, 5);
  //   // var angle;
  //   // switch (r) {
  //   //   case 3:
  //   //     var r3 = randomnum(angle3[0], angle3[1]);
  //   //     angle = r3;

  //   //     break;
  //   //   case 4:
  //   //     var r4 = randomnum(angle4[0], angle4[1]);
  //   //     angle = r4;

  //   //     break;
  //   //   case 5:
  //   //     var r5 = randomnum(angle5[0], angle5[1]);
  //   //     angle = r5;

  //   //     break;
  //   // }
  //   myreturn.prize = "运气不佳!";

  // }
	var myreturn = new Object;
  myreturn.prize = 100;
  myreturn.angle = 150;
  myreturn.message = "test";
  return myreturn;
}
