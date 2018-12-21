-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: thitracnhiem
-- ------------------------------------------------------
-- Server version	5.6.41-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cauhoi`
--

DROP TABLE IF EXISTS `cauhoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cauhoi` (
  `MaCauHoi` char(10) CHARACTER SET utf8 NOT NULL,
  `MaMonHoc` char(10) CHARACTER SET utf8 DEFAULT NULL,
  `ChuDe` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `NoiDung` varchar(800) CHARACTER SET utf8 DEFAULT NULL,
  `CauA` varchar(800) CHARACTER SET utf8 DEFAULT NULL,
  `CauB` varchar(800) CHARACTER SET utf8 DEFAULT NULL,
  `CauC` varchar(800) CHARACTER SET utf8 DEFAULT NULL,
  `CauD` varchar(800) CHARACTER SET utf8 DEFAULT NULL,
  `DapAn` char(10) CHARACTER SET utf8 DEFAULT NULL,
  `MucDo` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`MaCauHoi`),
  KEY `FK_CauHoi_MonHoc` (`MaMonHoc`),
  CONSTRAINT `FK_CauHoi_MonHoc` FOREIGN KEY (`MaMonHoc`) REFERENCES `monhoc` (`MaMonHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cauhoi`
--

LOCK TABLES `cauhoi` WRITE;
/*!40000 ALTER TABLE `cauhoi` DISABLE KEYS */;
INSERT INTO `cauhoi` VALUES ('q1','M1','Giải tích','Phương trình sinx = cosx có nghiêm trong khoảng là:','1','4','5','2','CauC','De'),('q10','M1','Giải tích','Cho hàm số y = (cosx-1)/(cosx+2). Mệnh đề nào trong số các mệnh đề sau đây là sai?','Tập xác định của hàm số là R','Hàm số có giá trị lớn nhất bằng 0','Hàm số có giá trị nhỏ nhất bằng - 2','Hàm số tuần hoàn với chu kì T = 2','CauD','De'),('q11','M1','Giải tích','Hàm số nào sau đây có giá trị lớn nhất bằng 2?','y = tanx – cotx','y = 2tanx','y = √2(cosx – sinx)','y = sin(2x - π/4)','CauC','Trung binh'),('q111','M1','Gi?i tích','1+1 = ?','1','2','3','4','CauA','De'),('q12','M1','Giải tích','Giá trị nhỏ nhất của hàm số y = 3- 4sin2xcos2x là:','-1','2','1','3','CauB','Kho'),('q121','M1','Gi?i tích','2+3','1','2','3','5','CauD','De'),('q122','M2','tinh toan','1m= ?cm','10','100','1000','10000','CauB','De'),('q123','M1','tinh toan','2+2=?','1','2','3','4','CauD','De'),('q126','M1','Giải tích','độ sôi của nước','90','100','110','1200','CauB','De'),('q13','M1','Giải tích','Hàm số y = √(1-cos2x) có chu kì là:','2π','√2π','π','√π','CauA','De'),('q14','M1','Giải tích','Hai hàm số nào sau đây có chu kì khác nhau?','cos(x/2) và sin(x/2)','Sinx và tanx','cosx và cot(x/2)','tan2x và cot2x','CauC','Trung binh'),('q15','M1','Giải tích','Chu kì của hàm số y = 2sin(2x + π/3) -3cos(2x - π/4) là:','2π','π','π/2','4π','CauB','Kho'),('q16','M1','Đại số','1+1=?','1','2','3','4','CauB','De'),('q17','M1','Đại số','12+33=?','45','46','47','48','CauA','Trung binh'),('q18','M1','Đại số','126+1000=?','1256','1145','1126','1125','CauC','Kho'),('q19','M1','Đại số','85+12=?','92','93','96','97','CauD','De'),('q2','M1','Giải tích','Phương trình sin2x = 1 có nghiệm là:','π/2+k4π','π/2+kπ','π/4+k2π','π/4+kπ','CauA','Trung binh'),('q20','M1','Đại số','45+39=?','84','85','86','87','CauA','Trung binh'),('q21','M1','Đại số','1254+9652=?','10904','10905','10906','10907','CauC','Kho'),('q22','M1','Đại số','5+6=?','10','11','12','13','CauB','De'),('q23','M1','Đại số','Mạnh cầm một tờ giấy và lấy kéo cắt thành 7 mảnh sau đó nhặt một trong số bảy mảnh giấy đã cắt và lại cắt thành 7 mảnh. Mạnh cứ tiếp tục cắt như vậy. Sau một hồi, Mạnh thu lại và đếm tất cả các mảnh giấy đã cắt. Hỏi kết quả nào sau đây có thể xảy ra?','Mạnh thu được 122 mảnh','Mạnh thu được 123 mảnh','Mạnh thu được 120 mảnh','Mạnh thu được 121 mảnh','CauC','Trung binh'),('q24','M1','Đại số','Cho dãy số (un) xác định bởi un = n2 – 4n – 2. Khi đó u10 bằng:','48','60','58','10','CauC','Kho'),('q25','M1','Đại số','Cho dãy số zn = 1 + (4n – 3).2n','Dãy zn là dãy tăng','Dãy zn bị chặn dưới','Cả A và B đề sai','Cả A và B đều đúng','CauA','De'),('q26','M1','Đại số','Cho dãy số un = n2 – 4n + 7. Kết luận nào đúng?','Dãy (un) bị chặn trên','Dãy (un) bị chặn dưới','Dãy (un) bị chặn','Các mệnh đề A,B,C đều sai','CauB','Trung binh'),('q27','M1','Đại số','Cho dãy số un = 1+ (n +3).3n. khi đó công thức truy hồi của dãy là:','un+1 = 1 +3un với n≥1','un+1 = 1 +3un + 3n+1 với n≥1','un+1 = un + 3n+1 - 2 với n≥1','un+1 =3un + 3n+1 - 2 với n≥1','CauD','Kho'),('q28','M1','Đại số','Phép chứng minh sau đây nhận giá trị chân lí là gì?','Đúng','Sai','Không đúng không sai','Vừa đúng vừa sai','CauC','De'),('q29','M1','Đại số','Cho x≠0 và x +1/x là một số nguyên. Khi đó với mọi số nguyên dương n, có kết luận gì về T(n,x) = n+1/n.','T(n,x) là số vô tỉ','T(n,x) là số không nguyên','T(n,x) là số nguyên','Các kết luận trên đều sai','CauD','Trung binh'),('q3','M1','Giải tích','Phương trình sin2 x/3 = 1 có nghiệm là:','π/2+k2π','3π/2+k2π','3π/2+k3π','kπ','CauB','Kho'),('q30','M1','Đại số','8524+1960=?','10484','10485','10486','10487','CauA','Kho'),('q31','M2','Cơ học','Trong trường hợp nào dưới đây có thể coi một đoàn tàu như một chất điểm?','Đoàn tàu lúc khởi hành','Đoàn tàu đang qua cầu','Đoàn tàu đang chạy trên một đoạn đường vòng','Đoàn tàu đang chạy trên đường Hà Nội -Vinh','CauB','De'),('q32','M2','Cơ học','Một người đứng trên đường quan sát chiếc ô tô chạy qua trước mặt. Dấu hiệu nào cho biết ô tô đang chuyển động?','Khói phụt ra từ ống thoát khí đặt dưới gầm xe','Khoảng cách giữa xe và người đó thay đổi','Bánh xe quay tròn','Tiếng nổ của động cơ vang lên','CauC','Trung binh'),('q33','M2','Cơ học','Một chiếc xe lửa đang chuyển động, quan sát chiếc va li đặt trên giá để hàng hóa, nếu nói rằng:','1 và 2','2 và 3','1 và 3','1, 2 và 3','CauD','Kho'),('q34','M2','Cơ học','Trong các ví dụ dưới đây, trường hợp nào vật chuyển động được coi như là chất điểm?','Mặt Trăng quay quanh Trái Đất','Đoàn tàu chuyển động trong sân ga','Em bé trượt từ đỉnh đến chân cầu trượt','Chuyển động tự quay của Trái Đất quanh trục','CauB','De'),('q35','M2','Cơ học','Chọn đáp án đúng','Quỹ đạo là một đường thẳng mà trên đó chất điểm chuyển động','Quỹ đạo là một đường thẳng mà trên đó chất điểm chuyển động','Quỹ đạo là một đường mà chất điểm vạch ra trong không gian khi nó chuyển động','Một đường vạch sẵn trong không gian trên đó chất điểm chuyển động gọi là quỹ đạo','CauA','Trung binh'),('q36','M2','Cơ học','Khi chọn Trái Đất làm vật mốc thì câu nói nào sau đây đúng?','Trái Đất quay quanh Mặt Trời','Mặt Trời quay quanh Trái Đất','Mặt Trời đứng yên còn Trái Đất chuyển động','Cả Mặt Trời và Trái Đất đều chuyển động','CauB','Kho'),('q37','M2','Cơ học','Hành khách trên tàu A thấy tàu B đang chuyển động về phía trước. Còn hành khách trên tàu B lại thấy tàu C cũng đang chuyển động về phía trước. Vậy hành khách trên tàu A sẽ thấy tàu C:','Đứng yên','Chạy lùi về phía sau','Tiến về phía trước','Tiến về phía trước rồi sau đó lùi về phía sau','CauA','De'),('q38','M2','Cơ học','Người lái đò đang ngồi yên trên chiếc thuyền thả trôi theo dòng nước. Trong các câu mô tả sau đây, câu nào đúng?','Người lái đò đứng yên so với dòng nước','Người lái đò chuyển động so với dòng nước','Người lái đò đứng yên so với bờ sông','Người lái đò chuyển động so với chiếc thuyền','CauD','Trung binh'),('q39','M2','Cơ học','Với chiều (+) là chiều chuyển động, trong công thức s = 1/sat2 + v0t của chuyển động thẳng biến đổi đều, đại lượng có thể có giá trị dương hay giá trị âm là:','Gia tốc','Quãng đường','Vận tốc','Thời gian','CauC','Kho'),('q4','M1','Giải tích','Phương trình sin(πcos2x) = 1 có nghiệm là:','kπ','π+k2π','π/2+kπ','±π/6+kπ','CauD','De'),('q40','M2','Cơ học','Trong các trường hợp sau đây. Trường hợp nào không thể xảy ra cho một vật chuyển động thẳng?','vận tốc có giá trị (+) ; gia tốc có giá trị (+)','vận tốc là hằng số ; gia tốc thay đổi','vận tốc có giá trị (+) ; gia tốc có giá trị (-)','vận tốc có giá trị (-) ; gia tốc có giá trị (+)','CauB','De'),('q41','M2','Cơ học','Một vật tăng tốc trong một khoảng thời gian nào đó dọc theo trục Ox. Vậy vận tốc và gia tốc của nó trong khoảng thời gian này có thể:','vận tốc có giá trị (+) ; gia tốc có giá trị (-)','vận tốc có giá trị (-) ; gia tốc có giá trị (-)','vận tốc có giá trị (-) ; gia tốc có giá trị (+)','vận tốc có giá trị (+) ; gia tốc có giá trị bằng 0','CauA','Trung binh'),('q42','M2','Cơ học','Một chiếc bắt đầu tăng tốc từ nghỉ với gia tốc 2 m/s2. Quãng đường xe chạy được trong giây thứ hai là','4m','3m','2m','1m','CauA','Kho'),('q43','M2','Cơ học','Một chiếc xe đang chạy với tốc độ 36 km/h thì tài xế hãm phanh, xe chuyển động thẳng chậm dần đều rồi dừng lại sau 5s. Quãng đường xe chạy được trong giây cuối cùng là','2,5m','2m','1,5m','1m','CauD','De'),('q44','M2','Cơ học','Một chiếc xe bắt đầu tăng tốc từ v1 = 36 km/h đến v2 = 54 km/h trong khoảng thời gian 2s. Quãng đường xe chạy trong thời gian tăng tốc này là','25m','50m','75m','100m','CauC','Trung binh'),('q45','M2','Cơ học','Một chiếc xe đang chạy trên đường thẳng thì tài xế tăng tốc độ với gia tốc bằng 2 m/s2 trong khoảng thời gian 10s. Độ tăng vận tốc trong khoảng thời gian này là','10 m/s','20 m/s','15 m/s','Ko co đáp án','CauA','Kho'),('q46','M2','Nhiệt học','Câu nào sau đây nói về chuyển động của phân tử là không đúng?','Chuyển động của phân tử là do lực tương tác phân tử gây ra','Các phân tử chuyển động không ngừng','Các phân tử chuyển động càng nhanh thì nhiệt độ càng cao','Các phân tử khí không dao động quanh vị trí cân bằng','CauA','De'),('q47','M2','Nhiệt học','Câu nào sau đây nói về lực tương tác phân tử là không đúng?','Lực phân tử chỉ đáng kể khi các phân tử ở rất gần nhau','Lực hút phân tử có thể lớn hơn lực đẩy phân tử','Lực hút phân tử không thể lớn hơn lực đẩy phân tử','Lực hút phân tử có thể bằng lực đẩy phân tử','CauB','Trung binh'),('q48','M2','Nhiệt học','Câu nào sau đây nói về các phân tử khí lí tưởng là không đúng?','Có thể tích riêng không đáng kể','Có lực tương tác không đáng kể','Có khối lượng không đáng kể','Có khối lượng đáng kể','CauC','Kho'),('q49','M2','Nhiệt học','Tìm câu sai','Khí lí tưởng là khí mà thể tích của các phân tử có thể bỏ qua','Khí lí tưởng là khí mà khối lượng của các phân tử có thể bỏ qua','Khí lí tưởng là khí mà các phân tử chỉ tương tác với nhau khi va chạm','Khí lí tưởng gây áp suất lên thành bình','CauD','De'),('q5','M1','Giải tích','Hàm số y = 2cos2x – 1 là hàm tuần hoàn với chu kì:','T = π','T = 2π','T = π2','T = π/2','CauB','Trung binh'),('q50','M2','Nhiệt học','Khi nén khí đẳng nhiệt thì số phân tử trong một đơn vị thể tích','tăng tỉ lệ thuận với áp suất','không đổi','tăng tỉ lệ với bình phương áp suất','giảm tỉ lệ nghịch với áp suất','CauB','Trung binh'),('q51','M2','Nhiệt học','Phát biểu nào sau đây là không đúng khi nói về quá trình đẳng nhiệt của một lượng khí xác định?','Áp suất tỉ lệ nghịch với thể tích','Tích của áp suất và thể tích là một hằng số','Trên giản đồ p – V, đồ thị là một đường hypebol','Áp suất tỉ lệ với thể tích','CauC','Kho'),('q52','M2','Nhiệt học','Một xilanh chứa 150 cm3 khí ở 2.105 pa Pít-tông nén khí trong xilanh xuống còn 75 cm3. Nếu coi nhiệt độ không đổi thì áp suất trong xilanh bằng','2.105 P','4.105 P','3.105 P','5.105 P','CauB','De'),('q53','M2','Nhiệt học','Một bọt khí ở đáy hồ sâu 7,5 m nổi lên trên mặt nước. Giả sử nhiệt độ ở đáy hồ và mặt hồ là như nhau. Cho biết áp suất khí quyển po = 75 cmHg, và khối lượng riêng của thủy ngân là 1,36.104 kg/m3. Thể tích bọt khí đã tăng lên','1,74 lần','3,47 lần','1,50 lần','2 lần','CauA','Trung binh'),('q54','M2','Nhiệt học','Xét một quá trình đẳng tích của một lượng khí lí tưởng nhất định. Tìm phát biểu sai.','Độ biến thiên của áp suất tỉ lệ thuận với độ biến thiên của nhiệt độ','Áp suất tỉ lệ thuận với nhiệt độ tuyệt đối','Độ biến thiên của áp suất tỉ lệ thuận với độ biến thiên của nhiệt độ bách phân','Áp suất tỉ lệ thuận với nhiệt độ bách phân','CauC','Kho'),('q55','M2','Nhiệt học','Nếu nhiệt độ của một bóng đèn khi tắt là 25oC, khí sáng là 323oC, thì áp suất của khí trơ trong bóng đèn tăng lên là','10,8 lần','2 lần','1,5 lần','12,92 lần','CauA','De'),('q56','M2','Nhiệt học','Một chiếc lốp ô tô chứa không khí ở 25oC. Khi xe chạy nhanh, lốp xe nóng lên, áp suất khí trong lốp tăng lên tới 1,084 lần. Lúc này, nhiệt độ trong lốp xe bằng','50oC','27oC','23oC','30oC','CauB','Trung binh'),('q57','M2','Nhiệt học','Khi đung nóng một bình kín chứa khí để nhiệt độ tăng 1oC thì áp suất khí tăng thêm 1/360 áp suất ban đầu. Nhiệt độ ban đầu của khí là','73oC','37oC','87oC','78oC','CauD','Kho'),('q58','M2','Nhiệt học','Đại lượng không phải thông số trạng thái của một lượng khí là','thể tích','khối lượng','nhiệt độ','áp suất','CauA','De'),('q59','M2','Nhiệt học','Tập hợp ba thông số xác định trạng thái của một lượng khí xác định là','áp suất, thể tích, khối lượng','áp suất, nhiệt độ, thể tích','nhiệt độ, áp suất, khối lượng','thể tích, nhiệt độ, khối lượng','CauD','Trung binh'),('q6','M1','Giải tích','Hàm số y = sin(π/2-x) + cotx/3 là hàm tuần hoàn với chu kì:','T = π','T = 2π','T = 3π','T = 6π','CauC','Kho'),('q60','M2','Nhiệt học','Quá trình nào dau đây là đẳng quá trình','Đun nóng khí trong một bình đậy kín','áp suất, nhiệt độ, thể tích','nhiệt độ, áp suất, khối lượng','thể tích, nhiệt độ, khối lượng','CauB','Kho'),('q61','M1','Nguyên tử','Nguyên tử vàng có 79 electron ở vị nguyên t?. ?i?n tích h?t nhân c?a nguyên t? vàng là','+79','-79','-1,26.10-17 C','+1,26.10-17 C','CauB','De'),('q62','M1','Nguyên tử','Một nguyên tử có 12 proton và 12 nơtron trong hạt nhân. ?i?n tích c?a ion t?o thành khi nguyên t? này b? m?t 2 electron là','2+','12+','24+','10+','CauA','Trung binh'),('q64','M1','Nguyên t?','T??ng t??ng ta có th? phóng ??i h?t nhân thành m?t qu? bóng bàn có ???ng kính 4 cm thì ???ng kính c?a nguyên t? là bao nhiêu? Bi?t r?ng ???ng kính c?a nguyên t? l?n h?n ???ng kính c?a h?t nhân kho?ng 104 l?n','4m','40m','400m','4000m','CauD','De'),('q7','M1','Giải tích','Trong các hàm số sau, hàm số nào không là hàm chẵn và cũng không là hàm lẻ?','y = tanx - 1/sinx','y = √2 sin(x - π/4)','y = sinx + tanx','y = sin4x – cos4x','CauC','De'),('q70','M1','Nguyên tử','Nguyên tử nào sau đây có 8 electron ? lớp ngoài cùng?','1632X','1840Y','818Z','2452T','CauB','De'),('q73','M3','Nguyên tử','Cấu hình electron của nguyên tử nguyên tố X có dạng [Ne]3s23p3. Phát biểu nào sau đây là sai?','X ở ô số 15 trong bảng tuần hoàn','X là một phi kim','Nguyên tử của nguyên tố X có 9 electron p','Nguyên tử của nguyên tố X có 3 phân lớp electron','CauA','De'),('q74','M3','Nguyên tử','Cấu hình electron nào sau đây viết sai?','1s22s22p5','1s22s22p63s23p64s1','1s22s22p63s23p64s24p5','1s22s22p63s23p63d34s2','CauB','Trung binh'),('q75','M3','Nguyên tử','Trong nguyên tử X, lớp có mức năng lượng cao nhất là lớp M. Phân lớp p của lớp này có 4 electron. Số electron của nguyên tử X là','6','16','18','14','CauD','Kho'),('q76','M3','Hữu cơ','Ứng với công thức C4H8O2 có bao nhiêu este là đồng phân của nhau ?','2','3','4','5','CauD','De'),('q77','M3','Hữu cơ','Este có mùi dứa là','isoamyl axetat','etyl butirat','etyl axetat','geranyl axctat','CauC','Trung binh'),('q78','M3','Hữu cơ','Đun nóng este HCOOCH3 với một lượng vừa đủ dung dịch NaOH, sản phẩm thu được là','CH3COONa và C2H5OH','HCOONa và CH3OH','HCOONa và C2H5OH','CH3COONa và CH3OH','CauB','Kho'),('q79','M3','Hữu cơ','Xà phòng hoá chất nào sau đây thu được glixerol ?','tristearin','metyl axetat','metyl fomat','benzyl axetat','CauA','De'),('q8','M1','Giải tích','Hàm số y = (sinx + cosx)2 + cos2x có giá trị lớn nhất là:','1+?2','3','5','?2','CauA','Trung binh'),('q80','M3','Hữu cơ','Chất nào sau đây có phân tử khối lớn nhất ?','triolein','tripanmitin','tristearin','trilinolein','CauD','Trung binh'),('q82','M3','Hữu cơ','Đốt cháy hoàn toàn 0,9 gam một loại gluxit X thu được 1,32 gam CO2 và 0,54 gam H2O. X là chất nào trong số các chất sau ?','glucozơ','saccarozơ','tinh bột','xenlulozơ','CauB','De'),('q84','M3','Hữu cơ','Lượng glucozơ cần dùng để tạo ra 1,82 gam sobitol vói hiệu suất 80% là','2,25 gam','1,80 gam','1,82 gam','1,44 gam','CauD','Kho'),('q85','M3','Hữu cơ','Chất nào sau đây là đisaccarit ?','glucozo','saccarozo','tinh bột','xenlulozo','CauA','De'),('q86','M3','Hữu cơ','Chất nào sau đây có mạch cacbon phân nhánh ?','amilozo','amilopectin','saecarozơ','xenlulozo','CauB','Trung binh'),('q87','M3','Hữu cơ','Nhận định nào sau đây không đúng ?','Glucozo, fructozo, saccarozơ đều hoà tan được Cu(OH)2','Glucozo, fructozo đều có phản ứng tráng bạc','Cho I2 vào dung dịch hồ tinh bột rồi đun nóng thì thu được dung dịch màu xanh tím','Xenlulozo phản ứng với HNO3 dư có xúc tác thích hợp tạo xenluloza trinitrat','CauC','Kho'),('q88','M3','Hữu cơ','Cho 1 ml ancol etylic, 1 ml axit axetic và 1 giọt axit sunfuric đặc vào ống nghiệm. Lắc đều và đun nhẹ trên ngọn lửa đèn cồn, sau đó làm lạnh rồi thêm vào ống nghiệm 2 ml dung dịch NaCl bão hoà. Hiện tượng quan sát được là','dung dịch phân thành 2 lớp','xuất hiện chất rắn màu trắng kết tinh','dung dịch chuyển thành vẩn đục','không có hiện tượng gì','CauD','De'),('q89','M3','Hữu cơ','Cho vào bát sứ 1 ml dầu ăn và 2 ml dung dịch NaOH 40%, đun hỗn họp sôi nhẹ và khuấy đều, thỉnh thoảng thêm vài giọt nước để thể tích dung dịch không đổi. Sau 10 phút, rót thêm 5 ml dung dịch NaCl bão hoà nóng, khuấy nhẹ. Hiện tượng quan sát được là','có chất rắn màu trắng nổi lên','có chất rắn màu trắng lắng xuống','tạo dung dịch trong suốt','dung dịch phân thành 2 lớp','CauA','Trung binh'),('q9','M1','Giải tích','Hàm số y = √3sinx – cosx có giá trị nhỏ nhất là:','1 – √3','√3','-2','-1 - √3','CauC','Kho'),('q90','M3','Hữu cơ','Cho 5 giọt CuSO4 5% và 1 ml dung dịch NaOH 10% vào ống nghiệm, lắc nhẹ. Gạn bỏ lóp dung dịch, sau đó thêm vào 2 ml glucozơ 1% lắc nhẹ. Hiện tượng quan sát được là','có kết tủa đỏ gạch','Cu(OH)2 tan tạo dung dịch, màu xanh','Cu(OH)2 bị khử tạo Cu màu đỏ','Cu(OH)2 tan tạo dung dịch trong suốt','CauD','Kho');
/*!40000 ALTER TABLE `cauhoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `de_cau`
--

DROP TABLE IF EXISTS `de_cau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `de_cau` (
  `MaDe` char(10) CHARACTER SET utf8 NOT NULL,
  `MaCauHoi` char(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`MaDe`,`MaCauHoi`),
  KEY `MaCauHoi` (`MaCauHoi`),
  CONSTRAINT `FK__De_Cau__MaDe__76969D2E` FOREIGN KEY (`MaDe`) REFERENCES `dethi` (`MaDe`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `de_cau_ibfk_1` FOREIGN KEY (`MaCauHoi`) REFERENCES `cauhoi` (`MaCauHoi`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `de_cau`
--

LOCK TABLES `de_cau` WRITE;
/*!40000 ALTER TABLE `de_cau` DISABLE KEYS */;
INSERT INTO `de_cau` VALUES ('02','q1'),('D11','q1'),('02','q10'),('D11','q10'),('D2','q10'),('02','q11'),('D2','q11'),('D11','q111'),('D6','q111'),('D2','q12'),('D6','q121'),('D11','q123'),('D11','q13'),('D6','q14'),('02','q16'),('D11','q16'),('D2','q18'),('02','q19'),('D11','q19'),('D2','q2'),('02','q21'),('D2','q21'),('02','q22'),('D2','q22'),('D11','q23'),('D6','q23'),('D2','q24'),('D6','q24'),('02','q25'),('02','q27'),('02','q28'),('D11','q28'),('D6','q28'),('D11','q29'),('02','q3'),('D11','q3'),('02','q4'),('D11','q4'),('D6','q4'),('D2','q5'),('D6','q5'),('D11','q6'),('D6','q6'),('02','q61'),('D11','q62'),('03','q64'),('D6','q64'),('02','q7'),('D11','q7'),('03','q76'),('02','q8'),('03','q85'),('03','q86'),('03','q88'),('03','q89'),('D2','q9'),('03','q90');
/*!40000 ALTER TABLE `de_cau` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `de_lop`
--

DROP TABLE IF EXISTS `de_lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `de_lop` (
  `MaDe` char(10) CHARACTER SET utf8 NOT NULL,
  `MaLop` char(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`MaDe`,`MaLop`),
  KEY `MaLop` (`MaLop`),
  CONSTRAINT `FK__De_Lop__MaDe__787EE5A0` FOREIGN KEY (`MaDe`) REFERENCES `dethi` (`MaDe`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `de_lop_ibfk_1` FOREIGN KEY (`MaLop`) REFERENCES `lop` (`MaLop`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `de_lop`
--

LOCK TABLES `de_lop` WRITE;
/*!40000 ALTER TABLE `de_lop` DISABLE KEYS */;
INSERT INTO `de_lop` VALUES ('03','L1'),('D2','L1'),('02','L2'),('03','L2'),('D11','L2'),('D6','L2'),('03','L3');
/*!40000 ALTER TABLE `de_lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dethi`
--

DROP TABLE IF EXISTS `dethi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dethi` (
  `MaDe` char(10) CHARACTER SET utf8 NOT NULL,
  `TenDe` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `MonHoc` char(10) CHARACTER SET utf8 DEFAULT NULL,
  `SoCauHoi` int(11) DEFAULT NULL,
  `ThoiGianThi` int(11) DEFAULT NULL,
  `SoLanSubmit` int(11) DEFAULT NULL,
  `ThoiGianMo` datetime DEFAULT NULL,
  `ThoiGianDong` datetime DEFAULT NULL,
  PRIMARY KEY (`MaDe`),
  KEY `FK_DeThi_MonHoc` (`MonHoc`),
  CONSTRAINT `FK_DeThi_MonHoc` FOREIGN KEY (`MonHoc`) REFERENCES `monhoc` (`MaMonHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dethi`
--

LOCK TABLES `dethi` WRITE;
/*!40000 ALTER TABLE `dethi` DISABLE KEYS */;
INSERT INTO `dethi` VALUES ('02','Tích Phân','M1',15,20,4,'2018-12-15 00:00:00','2018-12-30 12:00:00'),('03','Nguyên Tố','M3',10,30,3,'2018-12-12 00:00:00','2019-01-12 12:00:00'),('D11','Giải Tích','M1',15,20,2,'2018-12-03 05:00:00','2018-12-04 12:00:00'),('D2','Hóa Học','M1',10,1,2,'2018-12-06 07:00:00','2018-12-20 00:00:00'),('D6','Giai Tich','M1',10,20,2,'2018-12-03 05:00:00','2018-12-06 12:00:00');
/*!40000 ALTER TABLE `dethi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diemtrungbinh`
--

DROP TABLE IF EXISTS `diemtrungbinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diemtrungbinh` (
  `MaDe` char(10) CHARACTER SET utf8 NOT NULL,
  `MaThanhVien` char(10) CHARACTER SET utf8 NOT NULL,
  `DiemTB` float DEFAULT NULL,
  PRIMARY KEY (`MaDe`,`MaThanhVien`),
  KEY `MaThanhVien` (`MaThanhVien`),
  CONSTRAINT `diemtrungbinh_ibfk_1` FOREIGN KEY (`MaThanhVien`) REFERENCES `thanhvien` (`MaThanhVien`) ON DELETE CASCADE,
  CONSTRAINT `diemtrungbinh_ibfk_2` FOREIGN KEY (`MaDe`) REFERENCES `dethi` (`MaDe`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diemtrungbinh`
--

LOCK TABLES `diemtrungbinh` WRITE;
/*!40000 ALTER TABLE `diemtrungbinh` DISABLE KEYS */;
INSERT INTO `diemtrungbinh` VALUES ('02','TV3',0.175),('02','TV4',1.15),('03','TV4',2.9);
/*!40000 ALTER TABLE `diemtrungbinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lop` (
  `MaLop` char(10) CHARACTER SET utf8 NOT NULL,
  `TenLop` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `NgayLap` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`MaLop`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` VALUES ('a9','Toan','20/12/2018'),('L1','V?t Lý ','06/12/2018'),('L2','Toán 3','06/12/2018'),('L3','Hóa Học 3','04/12/2018');
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop_tv`
--

DROP TABLE IF EXISTS `lop_tv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lop_tv` (
  `MaThanhVien` char(10) CHARACTER SET utf8 NOT NULL,
  `MaLop` char(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`MaThanhVien`,`MaLop`),
  KEY `MaLop` (`MaLop`),
  CONSTRAINT `lop_tv_ibfk_1` FOREIGN KEY (`MaLop`) REFERENCES `lop` (`MaLop`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `lop_tv_ibfk_2` FOREIGN KEY (`MaThanhVien`) REFERENCES `thanhvien` (`MaThanhVien`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop_tv`
--

LOCK TABLES `lop_tv` WRITE;
/*!40000 ALTER TABLE `lop_tv` DISABLE KEYS */;
INSERT INTO `lop_tv` VALUES ('TV10','a9'),('TV2','a9'),('TV3','a9'),('TV4','a9'),('TV4','L1'),('TV3','L2'),('TV4','L2');
/*!40000 ALTER TABLE `lop_tv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monhoc` (
  `MaMonHoc` char(10) CHARACTER SET utf8 NOT NULL,
  `TenMonHoc` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`MaMonHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES ('M1','Toán Học'),('M2','Vật Lý'),('M3','Hóa Học');
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhvien`
--

DROP TABLE IF EXISTS `thanhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thanhvien` (
  `MaThanhVien` char(10) CHARACTER SET utf8 NOT NULL,
  `TenThanhVien` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `NgaySinh` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `GioiTinh` char(3) CHARACTER SET utf8 DEFAULT NULL,
  `Email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `SoDienThoai` char(10) CHARACTER SET utf8 DEFAULT NULL,
  `DiaChi` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `PassWord` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `HinhAnh` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`MaThanhVien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhvien`
--

LOCK TABLES `thanhvien` WRITE;
/*!40000 ALTER TABLE `thanhvien` DISABLE KEYS */;
INSERT INTO `thanhvien` VALUES ('TV10','Nguyen thi a','2018-12-03','Nu','b@gmail.com','0901251145','quan 8','123',NULL),('TV12','Nguyen Van C','2018-12-03','Nam','C@gmail.com','0902151485','quan 5','123',NULL),('TV2','Nguyen Van B','2018-11-15','Nam','NVB@gmail.com','5111616516','Ha Noi','258',NULL),('TV3','Pham Van E','1998-07-15','Nam','Epv@gmail.com','845621200','Thu Duc','369',NULL),('TV4','Pham Thi G','1999-06-15','Nam','Gpt@gmail.com','0122546785','Binh Duong','85212',NULL);
/*!40000 ALTER TABLE `thanhvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER themUser  
AFTER INSERT ON ThanhVien
FOR EACH ROW
BEGIN 
	DECLARE username VARCHAR(50);
    DECLARE pass VARCHAR(50);
    DECLARE role VARCHAR(50);
    set role = 'Thisinh', 
		username = NEW.MaThanhVien,
		pass = NEW.PassWord ;
	INSERT INTO Users
			( UserName, PassWord, Role )
	VALUES  ( username, pass, role );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER  suaMatKhau AFTER UPDATE ON ThanhVien
FOR EACH ROW
BEGIN	
	UPDATE Users SET PassWord = NEW.PassWord WHERE UserName = NEW.MaThanhVien;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER xoaUser  AFTER DELETE ON ThanhVien
FOR EACH ROW
BEGIN
-- DECLARE username VARCHAR(50);
-- SET username = OLD.MaThanhVien;
DELETE FROM Users WHERE UserName= OLD.MaThanhVien;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `thi`
--

DROP TABLE IF EXISTS `thi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thi` (
  `MaDe` char(10) CHARACTER SET utf8 NOT NULL,
  `MaThanhVien` char(10) CHARACTER SET utf8 NOT NULL,
  `ThoiGianKetThuc` datetime NOT NULL,
  `Diem` float DEFAULT NULL,
  PRIMARY KEY (`MaDe`,`MaThanhVien`,`ThoiGianKetThuc`),
  KEY `MaThanhVien` (`MaThanhVien`),
  CONSTRAINT `thi_ibfk_1` FOREIGN KEY (`MaDe`) REFERENCES `dethi` (`MaDe`) ON DELETE CASCADE,
  CONSTRAINT `thi_ibfk_2` FOREIGN KEY (`MaThanhVien`) REFERENCES `thanhvien` (`MaThanhVien`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thi`
--

LOCK TABLES `thi` WRITE;
/*!40000 ALTER TABLE `thi` DISABLE KEYS */;
INSERT INTO `thi` VALUES ('02','TV3','2018-12-20 00:50:15',0),('02','TV3','2018-12-20 00:53:39',0),('02','TV3','2018-12-20 00:59:00',0.7),('02','TV3','2018-12-21 10:07:45',0),('02','TV4','2018-12-20 01:13:27',3.3),('02','TV4','2018-12-21 08:55:39',0),('02','TV4','2018-12-21 08:56:52',0),('02','TV4','2018-12-21 09:18:59',1.3),('03','TV4','2018-12-21 09:17:26',2.9);
/*!40000 ALTER TABLE `thi` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER tinhdiemTB  AFTER INSERT ON Thi
FOR EACH ROW
BEGIN
	DECLARE dem INT ;
    DECLARE De CHAR(10) ;
    DECLARE ThanhVien CHAR(10) ;
    DECLARE DiemThi FLOAT;
	SET De = NEW.MaDe,ThanhVien = NEW.MaThanhVien;
	SET dem= (SELECT COUNT(MaDe) FROM Thi WHERE MaDe=De AND MaThanhVien=ThanhVien),
    DiemThi = (SELECT AVG(Diem) FROM Thi WHERE MaDe=De AND MaThanhVien=ThanhVien);
	IF(dem=1) THEN
	
	INSERT INTO DiemTrungBinh
			( MaDe,MaThanhVien,DiemTB)
	VALUES  ( De,ThanhVien,DiemThi) ;
	
    ELSE UPDATE DiemTrungBinh SET DiemTB=DiemThi WHERE MaDe=De AND MaThanhVien=ThanhVien;
	
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `PassWord` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Role` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('hoangphuc','211','QLDT'),('quangphu','211','QLCH'),('TV10','123','Thisinh'),('TV12','123','Thisinh'),('TV2','258','Thisinh'),('TV3','369','Thisinh'),('TV4','85212','Thisinh'),('vannam','211','QLTSL');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'thitracnhiem'
--

--
-- Dumping routines for database 'thitracnhiem'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-21 14:35:19
