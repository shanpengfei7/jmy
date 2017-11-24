/*
Navicat MySQL Data Transfer

Source Server         : jmy
Source Server Version : 50173
Source Host           : 192.168.102.12:3306
Source Database       : w-mis

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-11-13 18:01:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `can_kao`
-- ----------------------------
DROP TABLE IF EXISTS `can_kao`;
CREATE TABLE `can_kao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `liangBiaoId` int(11) DEFAULT NULL,
  `zhiDaoYiJian` text,
  `jianYi` text,
  `yaoShan` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of can_kao
-- ----------------------------
INSERT INTO `can_kao` VALUES ('1', '0', '1', '您属于气郁体质，气郁质是由于长期情志不畅、气机郁滞而形成的以性格内向不稳定、忧郁脆弱、敏感多疑为主要表现的体质状态。肝性喜条达而恶抑郁，长期情志不畅，肝失疏泄，平素忧郁面貌，神情多烦闷不乐；气机郁滞，经气不利，胸胁胀满，走窜疼痛，多伴善太息，乳房胀痛；肝气横逆犯胃，胃气上逆则见嗳气呃逆；肝气郁结，气不行津，津聚为痰，气郁化火，灼津为痰，肝气加痰循经上行，搏结于咽喉，可见咽间有异物感，痰多；气机郁滞，脾胃纳运失司，可见食欲减退；肝藏魂，心藏神，气郁化火，热绕神魂，睡眠较差，惊悸怔忡，健忘；气郁化火，耗伤气阴，形体消瘦，大便偏干；舌淡红，苔薄白，脉象弦细，为气郁之象。', '1、环境\r\n（1）注意舒畅情志，放松身心，减少忧郁，居住环境适合宽敞明亮通风。\r\n（2）多参加社会活动、集体文娱活动，远离离丧、事故、灾难等刺激性场所。\r\n（3）尽量避免强烈刺激性检查与治疗。\r\n（4）宽松衣着，避免穿紧身衣裤。\r\n（5）养成良好地睡眠习惯，避免熬夜。\r\n2、理疗\r\n（1）可按摩太冲、合谷、阳陵泉、肝俞等穴，疏肝理气解郁。取穴定位：①太冲：在足背侧，当第一跖骨间隙的后方凹陷处，每次按压约5分钟。②合谷：拇、食两指之间凹陷中，第2掌骨之中点边缘处，坚持每日2-3次，每次10分钟。③阳陵泉：在小腿外侧，当腓骨头前下方凹陷处，可用拇指压活揉动40-50次。\r\n(2)足浴：取材松叶100克，竹叶50克，蜂蜜60克，白酒1000毫升。将松叶、竹叶洗净，切碎晾干，与蜂蜜同入白酒中，搅拌均匀，加盖密封浸泡30天即可。取50毫升倒入盆中，冲入开水700毫升，趁热熏蒸，待温度适宜时泡洗双脚，每日1次，每次30分钟。\r\n3、食疗\r\n（1）适宜食物：大麦、玉米、高粱等谷物类；蘑菇、萝卜、菠菜等蔬菜类；柑橘、大枣、花生、橄榄等果品类；对非饮酒禁忌者，适量饮用葡萄酒，有益促进血液循环。\r\n（2）慎食食物：避免食用乌梅、石榴、草莓等酸涩食物，避免多食冰冷食品，防止气滞。\r\n（3）注意事项：饮食规律，营养均衡，不可过饥过饱，多食粗粮，多食蔬果，多喝汤。\r\n4、运动\r\n（1）适当增加户外运动，如跑步、游泳、打球等。\r\n（2）体娱游戏，如下棋、打牌、瑜伽、太极拳等。', '1.膳食\r\n（1）橘皮粥\r\n【原料】橘皮50克，粳米100克。\r\n【制作】将橘皮研细末，粳米淘洗干净，放入锅内，加清水，煮至粥将成时，加入橘皮，再煮10分钟即成。本品理气运脾，用于脘腹胀满，不思饮食。\r\n（2）柴胡白芍炖乌龟\r\n【原料】乌龟1只，柴胡9克，桃仁10克，白芍10克。\r\n【制作】将龟洗净；其他药物煎汤去渣，入乌龟肉炖熟，饮汤。每周1-2次。\r\n（3）香附牛肉汤	\r\n【原料】香附15克，牛肉100克。\r\n【制作】将牛肉切成小块与香附（切洗）一起放入砂锅中，加水适量，文火熬1小时，加入盐、油等调料，即可食用。每周1次。\r\n（4）茉莉花粥\r\n【原料】茉莉花5克，粳米60克。\r\n【制作】将茉莉花用水煮开后捞出，入粳米煮粥，加白糖适量，调食，酌情食用5~7天。\r\n2. 茶饮\r\n（1）陈皮茶\r\n【原料】陈皮二十克，新鲜橘叶二十克。\r\n【制作】中火，煎煮二十分钟，用洁净纱布过滤。去渣，取汁即成。代茶，分上下午二次。频频饮用。\r\n（2）双花西米露\r\n【原料】西米50克，玫瑰花、茉莉花各20克。\r\n【制作】玫瑰花、茉莉花，以开水冲泡，备用；西米投入沸水中，以中小火煮致半透明，中间还留有一点白即可，约5-6分钟；滤去煮西米的热水（带糊状）；将半透明的西米倒入备好的玫瑰花、茉莉花水中，略加烧开，调入糖适量即可。\r\n（3）佛手茶\r\n【原料】取佛手10克（或鲜品20克）入杯。\r\n【制作】用沸水冲泡，代茶饮。\r\n（4）麦芽青皮饮\r\n【原料】生麦芽30克，青皮10克。\r\n【制作】将生麦芽、青皮洗净，一同加适量清水煮沸后去渣。每日1剂，代茶饮。\r\n3. 中成药\r\n逍遥丸、越鞠丸');
INSERT INTO `can_kao` VALUES ('2', '0', '1', '您属于气虚体质，气虚体质是由于元气不足，以气息低弱、机体、脏腑功能状态低下为主要特征的一种体质状态。由于一身之气不足，脏腑功能衰退，出现气短懒言，语音低怯，精神不振，目光少神；气虚不能推动血液上荣，则头晕，健忘，唇色少华，舌淡红，肌肉松软，肢体疲乏，大便不成形，便后仍觉未尽；脾虚气血补充则舌胖嫩、边有齿痕；气血生化乏源，机体失养，则面色萎黄，毛发不泽；气虚推动无力，则便秘而不结硬；气化无权，水津直趋膀胱，则小便偏多；气虚鼓动血行之力不足，则脉象虚缓。', '1. 环境\r\n(1)注意保暖，不要劳汗当风，不宜在寒凉、潮湿之地过多停留，防止外邪侵袭。\r\n(2)注意静养，不宜多言，不宜过思过悲，不宜过度劳累。 \r\n2. 理疗\r\n（1）可按摩足三里、气海、神阙穴，可以健脾补气益气，调整气虚状态。 取穴定位： ① 足三里：外膝眼向下量4横指，胫骨旁开1横指，每日1次，每次108下，以感觉酸痛为度；② 气海：脐下1.5寸，每日揉3分钟；③ 神阙：腹中部，脐中央，环绕神阙穴按摩，顺时针90次，逆时针90次，可重复进行。\r\n（2）足浴 ：选取川芎、人参叶各35克。 将上药加清水2000毫升，煎至水剩1500毫升时，澄出药液，倒入脚盆中，先熏蒸，待温度适宜时泡洗双脚，每晚临睡前泡洗1次，每次40分钟。 \r\n3. 食疗\r\n（1）适宜食物：小米、糯米、麸皮、扁豆、红薯等谷物类；牛肉、兔肉、猪肚、鸡肉、鸡蛋、刀鱼等肉类；菜花、胡萝卜、香菇、菠菜、黑木耳、银耳、蘑菇等蔬菜类；花生、橘子、葡萄、杨梅、山楂、橄榄等果品类。 \r\n（2）慎食食物：少食木薯、萝卜、芋头、土豆等滋腻食物及田螺、螃蟹、西瓜、梨、苦瓜、绿豆、海带、蚕豆、绿茶等寒凉食物。 \r\n（3）注意事项：饮食要规律，营养要均衡，不可过饥过饱，多食粗粮，多食蔬果，多喝汤。\r\n4. 运动\r\n（1）锻炼宜降低强度，如散步、太极拳、太极剑，不宜做大负荷运动和大出汗的运动。\r\n（2）益肾锻炼：① 屈肘上举：端坐，两腿自然分开，双手屈肘侧举，手指伸直向上，与两耳平。然后，双手上举，以两胁部感觉有所牵动为度，随即复原，可连做十次。可缓解气短、吸气困难等症。 ② 抛空：端坐，左臂自然屈肘，置于腿上，右臂屈肘，手掌向上，做抛物动作3-5次，然后，右臂放于腿上，左手做抛空动作，与右手动作相同，每日可做5遍。 ③ 荡腿：端坐，两脚自然下垂，先慢慢左右转动身体3次，然后，两脚悬空，前后摆动十余次。④ 摩腰：端坐，宽衣，将腰带松开，双手相搓，以略觉发热为度；再将双手置于腰间，上下搓摩腰部，直到腰部感觉发热为止。', '1.膳食\r\n（1）黄芪童子鸡\r\n【原料】童子鸡1只，黄芪9克，陈皮3克，粳米100克。\r\n【制作】将童子鸡洗净，用纱布袋包好生黄芪，取一根细线，一端扎紧纱布口袋，置于锅内，另一端则绑在锅柄上。在锅中加姜、葱及适量水煮汤，待童子鸡煮熟后，拿出黄芪包。加入盐，黄酒调味，即可食用。可益气补虚。\r\n（2）人参灵芝乌鸡汤\r\n【原料】人参切片10克，灵芝30克，乌骨鸡1只，调味品适量。\r\n【制作】人参片、灵芝装入鸡腹内，用砂锅炖至鸡肉烂熟即可。食鸡肉饮汤。每周1次。\r\n（3）参芪鲫鱼汤\r\n【原料】黄芪30克，党参20克，鲫鱼500克，香菇13朵。\r\n【制作】把鲫鱼起锅煎香后，加入药材等，水适量，大火煮开，改小火煮30分钟，吃肉饮汤。每周1次。\r\n（4）山药芡实粥\r\n【原料】山药50克，芡实50克，陈皮3克，粳米100克。\r\n【制作】将山药、芡实、陈皮与粳米同煮粥即成。每周1-2次。\r\n2. 茶饮\r\n（1）红枣枸杞茶\r\n【原料】黄耆5钱、枸杞5钱、红枣3颗。\r\n【制作】将材料全部放入锅中，倒入1500㏄的水，以大火煮至水滚后转小火续煮约15分钟即可。\r\n（2）山楂麦芽饮\r\n【原料】山楂15克，生麦芽30克，太子参15克。\r\n【制作】将山楂、麦芽、太子参洗净，用水煮沸，浸泡15分钟即成，代茶饮，随意饮用。\r\n（3）红糖姜茶\r\n【原料】生姜5片，红糖适量。\r\n【制作】将生姜洗净，切片，加水煮沸，小火再煮15分钟，加入红糖适量，游泳后或受寒后喝。\r\n3. 药酒 \r\n【原料】人参33克，黄芪25克，当归身20克，龙眼肉60克，川芎15克，熟地45克。\r\n【制作】用50度米酒浸泡1个月。\r\n4. 方剂 \r\n补中益气汤。组成：黄芪15克、人参（党参）15克、白术10克、炙甘草15克、当归10克、陈皮6克、升麻6克、柴胡12克、生姜9片、大枣6枚。\r\n5. 中成药\r\n十全大补丸、补中益气丸。');
INSERT INTO `can_kao` VALUES ('3', '0', '1', '您属于阳虚体质，是由于阳气不足、以虚寒现象为主要特征的体质。由于阳气亏虚，机体失却温熙，肌肉松软，手足不温，面色晃白，口唇色淡。阳虚神失温养，则精神不振，睡眠偏多。阳气亏虚则毛发易落，易出汗。阳气不能蒸腾，则见大便溏薄，小便清长。阳虚鼓动无力，则脉象沉迟。阳虚水湿不化，则口淡不可。', '1、环境\r\n（1）避免在寒冷潮湿的环境中长时间停留。\r\n（2）暖衣温食，尤要注意下肢及腰部保暖。\r\n（3）注意调节情绪，不要过悲过喜。\r\n（4）欣赏轻松、欢快、轻度兴奋的音乐，如《蓝色多瑙河》，《青春圆舞曲》、《维也纳森林》。\r\n2、理疗\r\n（1）可按摩中极、气海、关元、神阙、肾俞、命门等穴位。\r\n（2）足浴：取材干姜1两、附子1两、党参1两、当归1两、吴茱萸5钱。 清水8碗加材料煲45分钟，并隔渣取液，待暖，浸足20~30分钟。\r\n2、食疗\r\n（1）适宜食物：羊肉、猪肚、栗子、核桃、韭菜、茴香等。\r\n（2）慎食食物：螃蟹、西瓜、梨、苦瓜、绿豆、海带等。\r\n（3）注意事项：少食生冷黏腻食物。\r\n3、运动\r\n可选散步、慢跑、太极拳、跳绳等较缓和的运动项目，运动量不可过大，微微出汗即可。', '1.膳食\r\n（1）羊肉枸杞汤 \r\n【原料】羊腿肉1000克，枸杞子20克，生姜12克，料酒、葱段、大蒜、味精、食盐。 \r\n【制作】羊肉去筋膜，洗净切块，生姜切片。待锅中油烧热，倒进羊肉、料酒、生姜、大蒜等煸炒，炒透后，同放砂锅中，加清水适量，放入枸杞子等，用大火烧沸，再改用文火煨炖，至熟烂后，加入调料和匀即可。 \r\n（2）当归生姜羊肉汤 \r\n【原料】羊肉500克，当归20克，生姜30克。 \r\n【制作】当归、生姜冲洗干净，羊肉剔去筋膜，放入开水锅中略烫，除去血水后捞出，切片备用。当归，生姜，羊肉放入砂锅中，加清水、料酒、食盐，旺火烧沸后摊去浮沫，再改用小火炖至羊肉熟烂即成。本品温中补血，祛寒止痛，适合冬日食用。 \r\n2. 茶饮\r\n干姜茶\r\n【原料】干姜10g、红茶3g。 \r\n【制作】用干姜的煎煮液250ml泡茶饮用，冲饮至味淡。 \r\n3. 药酒\r\n【原料】巴戟60克，肉苁蓉45克，川杜仲33克，人参25克，鹿茸片18克，蛤蚧1对，川续断30克，骨碎补15克，冰糖75克，50度米酒1公斤。 \r\n【制作】将上述原料浸泡1个月。 \r\n4. 方剂 \r\n吴茱萸15克、党参30克、大枣五枚、生姜3大片。 \r\n5. 中成药 \r\n金匮肾气丸、理中丸、附子理中丸。');
INSERT INTO `can_kao` VALUES ('4', '0', '1', '您属于平和体质，具有强健壮实的体质状态。平和质先天禀赋良好，后天调养得当，故其神、色、形、态、局部特征等方面表现良好，性格随和开朗，平素患病较少，对外界环境适应能力较强。', '1.环境\r\n（1）注意避免天气骤变等外来伤害以及情绪波动等伤害。 \r\n（2）应培养豁达乐观的生活态度，及时调整不良情绪，保持心情愉快。 \r\n（3）顺从人体的生物钟调理起居，安排自己日常的规律生活，避免熬夜等不良生活习惯。 \r\n（4）根据季节变换制定出符合自己的起居作息制度，平素应注意保暖，不要劳汗当风，防止外邪侵袭。 \r\n2.理疗\r\n可在专科医生指导下进行艾灸疗、热敏灸疗、敷脐疗、中药沐足等理疗。\r\n3. 饮食调养\r\n（1）适宜食物：小米、粳米、糯米、扁豆、红薯、牛肉、兔肉、猪肚、鸡肉、鸡蛋、鲢鱼、鲨鱼、刀鱼、黄鱼、比目鱼、菜花、胡萝卜、香菇、豆腐、马铃薯等。\r\n（2）慎食食物：不可食用过于黏腻或难以消化的食物。 \r\n（3）注意事项：避免烟酒、浓茶、咖啡等刺激性食物。\r\n4.运动\r\n对运动要积极主动，兴趣广泛；运动适度不宜过量；循序渐进，持之以恒；全面锻炼。', null);
INSERT INTO `can_kao` VALUES ('5', '0', '1', '您属于阴虚体质，阴虚体质是由于体内津液精血等阴液亏少，以阴虚内热为主要特征的体质状态。阴液亏少，机体失却濡润滋养，体形瘦长，平素易口燥咽干，鼻微干，大便干燥，小便短，眩晕耳鸣，两目干涩，视物模糊、皮肤偏干，易生皱纹，舌少津少苔，脉细；同时由于阴不制阳，阳热之气相对偏旺而生内热，表现为一派虚火内绕的证侯，可见手足心热，口渴喜冷饮，面色潮红，有烘热感，唇红微干，睡眠差，舌红脉数等。', '1. 环境\r\n（1）保证充足的睡眠时间，避免高温作业，剧烈运动，特别是冬季尽量少出汗以护阴精。 \r\n（2）要节制房事，惜阴保精。 \r\n（3）保持二便通畅。 \r\n（4）调节情志，平和心态。\r\n2.理疗\r\n可按摩肝俞、肾俞、三阴交、足三里等穴位。\r\n3. 饮食\r\n（1）适宜食物：芝麻、糯米、绿豆、乌贼、龟、海参、鲍鱼、螃蟹、牛奶、牡蛎、蛤蜊、海蜇、鸭肉、猪皮、豆腐、桃子、银耳、蔬菜、水果等。 \r\n（2）慎食食物：忌吃辛辣刺激性食品、温热香燥食品、煎炒炸烹食品。 \r\n（3）注意事项：饮食规律，营养均衡，不可过饥过饱，多食粗粮，多食蔬果，多喝汤。\r\n 4. 运动 \r\n适合做中小强度运动，如太极拳、八段锦、广播体操等， 锻炼身体时要控制在微汗即可，并及时补充水分。 ', '1.膳食\r\n（1）莲子百合煲瘦肉 \r\n【原料】莲子（去芯）20克、百合20克、猪瘦肉100克。 \r\n【制作】将以上原料加水适量同煲，肉熟烂后用盐调味食用，每日1次。有清心润肺，益气安神之功效。适用于阴虚质见干咳，失眠，心烦，心悸等症者食用。 \r\n（2）生地骨皮粥 \r\n【原料】生地20克地骨皮15克，粳米100克。 \r\n【制作】粳米洗净,与上二药同入锅中，加水煮至烂，食用时加少许盐调之，每日2次，早晚餐用。 \r\n（3）银耳绿豆粥 \r\n【原料】银耳10克，绿豆20克，粳米100克。 \r\n【制作】粳米洗净，银耳、绿豆分别用温水浸泡2小时，共入锅中煮至粥烂即成，食时加白糖少许调之，每日2次，早晚餐用。 \r\n2. 茶饮 \r\n（1）菊花麦冬茶 \r\n【原料】菊花10克，麦冬10克。 \r\n【制作】将菊花、麦冬加水500毫升，煎20分钟，调入白糖适量，凉后代茶饮。 \r\n（2）地麦茶 \r\n【原料】生地5g、麦冬3g、天冬3g、绿茶3g。 \r\n【制作】用250ml开水冲泡后饮用，冲饮至味淡。 \r\n3. 药酒 \r\n【原料】女贞子250克，烧酒750克。 \r\n【制作】将女贞子捣碎，浸于酒中，浸5天后即可饮用。每次饮用20毫升，每天2 次。 \r\n4. 方剂 \r\n北沙参，麦冬，当归身各9克，生地黄20克，枸杞子20克，川楝子5克。 \r\n5. 中成药 \r\n杞菊地黄丸、热甚者可服；六味地黄丸；知柏地黄丸；麦味地黄丸。');
INSERT INTO `can_kao` VALUES ('6', '0', '1', '您属于痰湿体质，痰湿体质是由于水液内停而痰湿凝聚，以粘滞重浊为主要特征的体质状态。痰湿泛于肌肤，则见体形肥胖，腹部肥满松软，面色黄胖而黯，眼胞微浮，面部皮肤油脂较多，多汗且黏；“肺为贮痰之器”，痰浊停肺，肺失宣降，则胸闷，痰多；“脾为生痰之源”，故痰湿质多喜食肥甘；痰湿困脾，阻滞气机，困遏清阳，则容易困倦，身重不爽；痰浊上泛于口，则口黏腻或甜；脾湿内阻，运化失健则大便不实，小便微混；水湿不运，则小便不多。舌体胖大，舌苔白腻，脉滑，为痰湿内阻之象。', '1. 环境\r\n（1）衣着应透气散湿，经常晒太阳或进行日光浴。 \r\n（2）在湿冷的气候条件下，要减少户外活动，避免受寒雨淋，保持居室干燥。 \r\n（3）不宜居住在潮湿的环境里。 \r\n（4）养成良好的睡眠习惯，夜间11点前卧床休息，避免熬夜。\r\n（5）学会运用倾诉、听音乐、适当运动等多种方式自我排遣，舒畅心情，调畅气机。 \r\n2.理疗\r\n（1）可按摩足三里、丰隆、天枢、脾俞等穴健脾利湿化痰，改善体质。 取穴定位：① 足三里：外膝眼向下量4横指，胫骨旁开1横指，每日1次，每次108下，以感觉酸痛为度；② 丰隆：外踝上8寸，胫骨前缘外侧1.5寸，胫腓骨之间，每日按压1~3分钟；③ 脾俞：第11胸椎棘突下旁开1.5寸，日一次，每次约按揉1~3分钟；④ 天枢：人体中腹部，肚脐向左右旁开2寸，即三横指处，每日一次，每次约揉50下。 \r\n（2）胆经局部按摩：将一手四指置患者左小腿外侧阳陵泉,轻缓向下抚摩，至悬钟穴止，反复操作1-2分钟，之后，同法按摩右腿。 \r\n（3）敲打胆经：沿双侧大腿外侧中线位置，自上而下循经敲打至外踝前足背处，每日敲打200下，有疏肝利胆的作用。\r\n（4）足浴：取材丁香5钱、胡椒5钱、泽兰1两、益母草1两、赤小豆1两。 清水8碗加材料煲45分钟，隔渣取液，待暖，浸足20~30分钟。\r\n3. 饮食调养 \r\n（1）适宜食物：文蛤、海蜇、胖头鱼、乌骨鸡，鸭肉，鹅肉，猪蹄，驴肉等肉类；萝卜、洋葱、冬瓜、紫菜、菠菜、黑木耳、香菇、银耳、蘑菇等蔬菜类；扁豆、蚕豆、花生、橄榄、大枣、山楂、南瓜子、黑芝麻、莲子、橘子、葡萄、杨梅等果品类。 \r\n（2）慎食食物：少食肥甘厚腻、生冷滋润之品；不宜烈酒，咖啡、鱼子、虾蟹和过咸过甜、不易消化的食物；忌烟、限酒、避免辛辣饮食。\r\n（3）注意事项：饮食规律，营养均衡，不可过饥过饱，多食粗粮，多食蔬果，多喝汤，少甜食，保证早餐质量，晚餐宜清淡，避免肝胆负担。\r\n4. 运动调养 \r\n（1）应根据自己的具体情况循序渐进，长期坚持运动锻炼。 \r\n（2）宜选择中小强度较长时间的全身运动，如散步、慢跑、乒乓球、羽毛球、武术，以及适合自己的各种舞蹈。 \r\n（3）运动时间应当在下午2：00-4：00阳气极盛之机，运动环境温暖宜人。', '1.膳食\r\n（1）山药冬瓜汤 \r\n【原料】山药50克，冬瓜150克。 \r\n【制作】将上述原料同置锅中慢火煲30分钟，调味后即可饮用。本品可健脾、益气、利湿。 \r\n（2）白茯苓粥 \r\n【原料】白茯苓粉15克，粳米100克，胡椒粉、盐少许。 \r\n【制作】粳米淘净。粳米茯苓粉放入锅，加水适量，用武火烧沸，转用文火炖至糜烂，再加盐、胡椒粉，搅匀即成。每日2次，早晚餐用。 \r\n（3）苡仁赤豆粥 \r\n【原料】薏苡仁、赤小豆各30克。 \r\n【制作】共入锅加水煮至豆烂，加入白糖适量服食。每周3-5次。 \r\n（4）砂仁煲猪肚 \r\n【原料】猪肚250克，砂仁10克。 \r\n【制作】猪肚洗净、切块，与砂仁共入锅，加清水适量，共煲至猪肚熟烂，加盐调味。饮汤，食肉。每周2-3次。 \r\n2.茶饮\r\n（1）泽泻乌龙茶 \r\n【原料】泽泻15克，乌龙茶3克。 \r\n【制作】将泽泻加水煮沸20分钟，取药汁冲泡乌龙茶。 \r\n（2）藿香糖水 \r\n【原料】藿香10克，白糖适量。 \r\n【制作】藿香放煲内，加水2碗，煎水，加白糖，煮片刻，去渣。代茶饮。 \r\n（3）山楂降脂饮 \r\n【原料】鲜山楂30克，生槐花5克，嫩荷叶15克，草决明10克。 \r\n【制作】将以上四味同放锅内煎煮，待山楂将烂时，捣碎，再煮10分钟，去渣取汁，调入白糖。 \r\n3.中成药 \r\n金匮肾气丸。');
INSERT INTO `can_kao` VALUES ('7', '0', '1', '您属于湿热体质，湿热体质是以湿热内蕴为主要特征的体质状态。湿热泛于肌肤，则见形体偏胖，平素面垢油光，易生痤疮粉刺；湿热郁蒸，胆气上溢，则口苦口干；湿热内阻，阳气被遏，则身重困倦；热灼血络，则眼津红赤；热重于湿，则大便燥结；湿重于热，则大便黏滞；湿热寻肝经下注，则阴囊潮湿，或带下量多。小便短赤，舌质偏红苔黄腻，脉象滑数，为湿热内蕴之象。', '1. 环境\r\n（1）不要长期熬夜，或过度疲劳，按时作息，要保持二便通畅。 \r\n（2）保持居所的干爽及环境的通风。 \r\n（3）注意舒缓情志，学会喜与忧、苦与乐、顺与逆的正确对待，保持稳定的心态。 \r\n（4）多参加社会活动，寻求快乐，培养乐观向上的情绪。 \r\n2.理疗\r\n（1）可按摩足三里、丰隆、天枢、脾俞等穴健脾利湿，改善体质。 取穴定位：① 足三里：外膝眼向下量4横指，胫骨旁开1横指，每日1次，每次100下，以感觉酸痛为度；② 丰隆：外踝上8寸，胫骨前缘外侧1.5寸，胫腓骨之间，每日按压3分钟；③ 天枢：中腹部，肚脐向左右旁开2寸，即三横指处，每日一次，每次约揉50下。④ 脾俞：第11胸椎棘突下旁开1.5寸，日一次，每次约按揉3分钟； \r\n（2）敲打胆经：沿双侧大腿外侧中线位置，自上而下循经敲打至外踝前足背处，每日敲打200下。 \r\n（3）足浴：取材茯苓、黄精、玉竹各15克，神曲20克，当归、生地、白芍各10克。 将上药加清水适量，浸泡20分钟，煎数沸，取药液与1500毫升开水同入脚盆中，趁热熏蒸，待温度适宜时泡洗双脚，每天2次，每次40分钟。\r\n3.食疗\r\n（1）适宜食物：薏苡仁、红小豆、绿豆等谷物类；鸭肉、鲫鱼等肉类；冬瓜、丝瓜、苦瓜、黄瓜、西瓜、白菜、芹菜等蔬菜类。 \r\n（2）慎食食物：禁忌如辣椒、生姜、大葱、大蒜等辛辣燥烈、大热大补的食物；少食狗肉、鹿肉、牛肉、羊肉、酒等温热食品和饮品。 \r\n（3）注意事项：饮食规律，营养均衡，不可过饥过饱，多食粗粮，多食蔬果，多喝汤， 保证早餐质量，晚餐宜清淡，避免肝胆负担。\r\n4. 运动\r\n适宜做大强度、大运动量的体育锻炼，如中长跑、游泳、爬山、各种球类、武术等。', ' 1.膳食\r\n（1）泥鳅炖豆腐 \r\n【原料】泥鳅500克，豆腐250克。 \r\n【制作】泥鳅去腮及内脏，冲洗干净，放入锅中，加清水，煮至半熟，再加豆腐，食盐适量，炖至熟烂即成。可清利湿热。 \r\n（2）白茯苓粥 \r\n【原料】白茯苓粉15克，粳米100克，盐少许。 \r\n【制作】粳米淘净。粳米茯苓粉放入锅，加水适量，用武火烧沸，转用文火炖至糜烂，再加盐，搅匀即成。每日2次，早晚餐用。 \r\n（3）苡仁赤小豆粥 \r\n【原料】薏苡仁、赤小豆各50克。 \r\n【制作】共入锅加水煮至豆烂，加入白糖适量服食。每日1次。 \r\n2. 中药茶饮\r\n山楂水红子茶\r\n【原料】山楂30克，水红子10克。 \r\n【制作】将二药同放锅内煎煮，待山楂将烂时，滤去药渣取汁，调入白糖适量，代茶饮。 \r\n3. 方剂 \r\n【原料】猪苓(去皮)、茯苓、泽泻、阿胶、滑石(碎)各9克。 \r\n【制作】以水800毫升，先煮四味，取400毫升，去津，入阿胶烊消，分二次温服。 \r\n4. 中成药\r\n防风通圣丸。 ');
INSERT INTO `can_kao` VALUES ('8', '0', '1', '您属于淤血体质，瘀血质是体内有血液运行不畅的潜在倾向或瘀血内阻的病理基础，并表现出一系列外在征象的体质状态。血行不畅，气血不能濡养机体，则形体消瘦，发易脱落，肌肤干或甲错；不通则痛，易患疼痛，女性多见痛经；血行淤滞，可见血色变紫变黑，面色晦暗，皮肤偏黯，口唇黯淡或紫，眼眶暗黑，鼻部黯滞；脉络淤阻，可见皮肤色素沉着，易出现瘀斑，妇女闭经，舌质黯有点、片状瘀斑，舌下静脉曲张，脉象细涩或结代；血液郁积不散而凝结成块，则见经色紫黑有块，不循经而溢出脉外，则见崩漏。', '1.环境\r\n（1）注意保暖，避免寒冷刺激，甚至在盛夏时节也不可贪冷，环境温度不可过低。 \r\n（2）日常生活中应注意动静结合，不可贪图安逸，加重气血郁滞。 \r\n（3）养成良好的睡眠习惯，晚夜间11点前卧床休息，避免熬夜。 \r\n（4）正确对待现实生活，建立良好的人际氛围，养成高尚的人生志趣，有困难主动寻求他人和社会的帮助。在非原则问题上，也要得理让人。 \r\n（5）应培养乐观的情绪，精神愉快则气血和畅，益于瘀血质的改善。\r\n2.理疗\r\n（1）按摩三阴交、合谷、血海等穴，活血化瘀。 取穴定位：① 三阴交：在足内踝上3寸，每日约揉1~3分钟，有活血化瘀之功。② 合谷：拇、食两指之间凹陷中，第2掌骨之中点边缘处，每日约拿3~5次，揉100~300次。③ 血海：屈膝，在大腿内侧，髌底内侧端上2寸，当股四头肌内侧头的隆起处。 \r\n（2）足浴：选取当归30g、威灵仙30g、乳香15g、没药15g、栀子15g， 将以上原料水煎、每日2-3次足浴。 \r\n3. 食疗\r\n（1）适宜食物：猪心、牛肉、羊肉、羊血、海参、猪蹄、驴肉等肉食类；黑木耳、洋葱、茄子、胡萝卜、菠菜、银耳、香菇、蘑菇、等蔬菜类；、芒果、山楂、大枣、南瓜子、花生、黑芝麻、莲子、橄榄等果品类；红糖、黄酒、葡萄酒等酒水类。对非饮酒禁忌者，适量饮用葡萄酒，对促进血液循环有益。 \r\n（2）慎食食物：凡具有涩血作用的食物都应忌食，如乌梅、石榴、苦瓜、柿子、李子、花生米等；高脂肪、高胆固醇的食物也不可多食，如蛋黄、虾子、猪头肉、奶酪等。 \r\n（3）注意事项：饮食规律，营养均衡，不可过饥过饱，多食粗粮，多食蔬果，多喝汤，少盐，保证早餐质量，晚餐宜清淡，避免肝胆负担。\r\n 4. 运动 \r\n可多采用一些有益于促进气血运行的运动项目，坚持经常性锻炼，如按摩、太极拳、太极剑、各种舞蹈、步行健身法、徒手健身操等。', '1.膳食\r\n（1）桃仁粥 \r\n【原料】桃仁30克，粳米150克。 \r\n【制作】先把桃仁捣烂如泥，加水研汁，去渣，放入粳米煮为稀粥，即可服食。可供2人服，每周1-2次。 \r\n（2）人参三七鸡 \r\n【原料】人参5克，三七6克，生姜3片，鸡肉200克。 \r\n【制作】将人参、三七、鸡肉放炖盅，加入适量清水，隔水炖2小时，食盐调味，服食。每周1-2次。 \r\n（3）当归瘦肉盅\r\n【原料】瘦肉100克，当归10克，味精、食盐适量。 \r\n【制作】将瘦肉洗净，切成小块；当归洗净、切片；将瘦肉与当归装入钵内，酌加清水、食盐，入笼屉中蒸1个半小时，加入味精，即可食用。每周2次。 \r\n2.茶饮 \r\n（1）山楂红糖汤 \r\n【原料】山楂10枚，红糖适量。 \r\n【制作】山楂冲洗干净，去核打碎，放入锅中，加清水煮约20分钟，调以红糖进食。可活血散瘀。 \r\n（2）灵芝三七山楂饮 \r\n【原料】灵芝30克，三七粉4克，山楂汁200毫升。 \r\n【制作】先将灵芝洗净，放入砂锅中，注入适量清水，微火煎熬1小时。去渣取汁，兑入三七粉和山楂汁即成。每日1剂，早晚各1次，服前摇匀。 \r\n（3）黑木耳羹 \r\n【原料】黑木耳6克，白糖少量。 \r\n【制作】将黑木耳洗净泡开，入锅煮沸后，文火煨烂，加入白糖调匀。 \r\n3. 药酒 \r\n【原料】田七85克（打碎或切片），当归25克，川续断33克，苏木28克，川芎30克，红花18克，延胡索35克，香附15克，冰糖70克，50度米酒1公斤。 \r\n【制作】浸泡1个月。 \r\n4. 方剂 \r\n熟地15克、当归15克、白芍10克、川芎8克、桃仁9克、红花6克。 \r\n5. 中成药\r\n云南白药、桂枝茯苓丸（妇科多用）。 ');
INSERT INTO `can_kao` VALUES ('9', '0', '1', '您属于过敏体质，由于遗传等因素、或环境因素不同影响，故特禀质的形体特征、心理特征、常见表现、发病倾向等方面存在诸多差异，病机各异。', '1.环境\r\n（1）根据个体情况调护起居。在陌生的环境中要注意日常保健，减少户外活动，避免接触各种致敏的动植物，适当服用预防性药物，减少发病机会。 \r\n（2）在季节更替之时，要及时增减衣被，增强机体对环境的适应能力。 \r\n（3）避免接触花粉、尘螨、鱼虾、动物皮毛、霉菌等致敏因素。\r\n（4）保持积极的态度，平和的心态，提高对环境的适应能力。工作生活避免过度疲劳；遇事冷静，避免过度紧张。 \r\n2.理疗\r\n（1）可按摩足三里、涌泉、曲池、血海等穴位。 \r\n（2）足浴：取材当归15克、黄芪20克、红花10克、苏木10克、泽兰10克、生地10克、川椒10克、葛根15克、细辛6克、黄芩15克、伸筋草15克、酸枣仁15克，煎汤凉置45摄适度浴足。 \r\n3.食疗\r\n（1）适宜食物：多食清淡食物，如胡萝卜、菠菜、银耳等蔬菜类。\r\n（2）慎食食物：忌生冷、辛辣、肥甘油腻，及各种“发物”，如鱼、虾、蟹、辣椒、肥肉、浓茶、咖啡等。\r\n（3）注意事项：饮食规律，营养均衡，避免食用各种致敏食物，不可过饥过饱，多食粗粮，多食蔬果，多喝汤。\r\n4. 运动\r\n可进行步行健身法、慢跑等中小强度的健身运动；避免春天或季节交替时长时间在野外锻炼，防止过敏性疾病的发作。 ', '1.膳食\r\n（1）固表粥 \r\n【原料】乌梅15克，黄芪20克，当归12克，粳米100克。 \r\n【制作】将乌梅、黄芪、当归放入砂锅中加水煎开，再用小火慢煎成浓汁，取出药汁后，再加水煎开后取汁，用汁煮粳米成粥，加冰糖趁热食用。可养血消风，扶正固表。 \r\n（2）当归羊肉汤 \r\n【原料】当归15克，生姜10克，羊肉汤100克。 \r\n【制作】加盐适量煎汤，每日2次服用。 \r\n（3）当归补血汤 \r\n【原料】黄芪50克，当归10克。 \r\n【制作】水煎每日2次服用。 \r\n（4）玉屏风散 \r\n【原料】黄芪30克，防风15克，白术10克。 \r\n【制作】水煎每日2次服用。 \r\n2. 茶饮\r\n乌梅15g、黄芪20g、当归12克、冰糖适量，水煮当茶。 \r\n3. 中成药\r\n玉屏风散 ');
INSERT INTO `can_kao` VALUES ('10', '0', '2', '无焦虑症状（总分0-7分）', null, null);
INSERT INTO `can_kao` VALUES ('11', '0', '2', '轻度焦虑（总分8-14分）：偶有紧张、敏感、担忧、害怕等情绪,伴心跳加快、心慌、头晕、胸闷气短。入睡困难、早醒、多梦等。', null, null);
INSERT INTO `can_kao` VALUES ('12', '0', '2', '轻—中度焦虑（总分15-21分）：常有过分担忧、焦虑不安、注意力不集中，伴心跳加快、口干、小便频繁、小动作增多、坐立不安，搓手顿足等症。入睡困难，早醒，多梦，醒后无轻松感。', null, null);
INSERT INTO `can_kao` VALUES ('13', '0', '2', '中度焦虑（总分22-28分）：常有烦躁易怒、敏感多疑、过分担忧、焦虑不安、注意力不集中，伴心慌、心跳加快、口干、小便频繁、肌肉震颤、小动作增多、坐立不安，反复徘徊，搓手顿足等症。入睡困难，早醒，多梦，醒后无轻松感。反复就医。', null, null);
INSERT INTO `can_kao` VALUES ('14', '0', '2', '中-重度焦虑（总分29-35分）：常有担心，紧张，惶恐不安，焦躁，易激惹，伴坐卧不宁，呼吸急促，心跳加快，出汗，濒死感等症，反复急诊就诊。严重睡眠障碍，多梦。', null, null);
INSERT INTO `can_kao` VALUES ('15', '0', '2', '重度焦虑（36分以上）：整日担心，紧张，惶恐不安，焦躁，易激惹，伴坐卧不宁，呼吸急促，心跳加快，心慌，大汗淋漓，濒死感等症，反复急诊就诊。严重睡眠障碍，入睡困难，睡眠不稳不深，早醒，多梦，梦魇，从睡眠中突然惊醒。', null, null);
INSERT INTO `can_kao` VALUES ('18', '0', '3', '无抑郁症状（总分0-7分）', null, null);
INSERT INTO `can_kao` VALUES ('19', '0', '3', '轻度抑郁（总分8-19分）：偶有情绪低落，兴趣减退，消极认知，烦躁等情绪，伴周身乏力、食欲减退、体重下降等症。入睡困难、早醒、多梦等。', null, null);
INSERT INTO `can_kao` VALUES ('20', '0', '3', '中度抑郁（总分20-34分）：常有情绪低落，兴趣减退，言语减少，思维减缓，注意力不集中，消极观念，情绪反应呈昼重夜轻变化等，伴周身乏力，食欲减退，体重下降等症。入睡困难，早醒，多梦，醒后无轻松感等。', null, null);
INSERT INTO `can_kao` VALUES ('21', '0', '3', '重度抑郁（总分35分以上）：严重情绪低落，兴趣减退，思维迟滞，伴自责自罪等消极观念,无助感和绝望感，可有自杀自残等消极行为，社会性退缩明显，食欲严重减退，体重减轻，严重睡眠障碍。', null, null);
INSERT INTO `can_kao` VALUES ('22', '0', '4', '生物性躯体症状', '常规生物治疗', null);
INSERT INTO `can_kao` VALUES ('23', '0', '4', '抑制性躯体症状', '药物治疗结合认知行为治疗、低频治疗', null);
INSERT INTO `can_kao` VALUES ('24', '0', '4', '激惹性躯体症状', '药物治疗结合认知行为治疗、低频治疗', null);
INSERT INTO `can_kao` VALUES ('25', '0', '4', '想象性躯体症状', '药物助疗结合生物反馈治疗', null);
INSERT INTO `can_kao` VALUES ('26', '0', '4', '认知性躯体症状', '药物治疗结合认知行为治疗', null);
INSERT INTO `can_kao` VALUES ('27', '0', '5', '躯体化：无躯体化症状', null, null);
INSERT INTO `can_kao` VALUES ('28', '0', '5', '强迫：无强迫症状', null, null);
INSERT INTO `can_kao` VALUES ('29', '0', '5', '人际关系：无人际关系敏感问题', null, null);
INSERT INTO `can_kao` VALUES ('30', '0', '5', '抑郁：无抑郁症状', null, null);
INSERT INTO `can_kao` VALUES ('31', '0', '5', '焦虑：无焦虑症状', null, null);
INSERT INTO `can_kao` VALUES ('32', '0', '5', '敌对：无敌对症状', null, null);
INSERT INTO `can_kao` VALUES ('33', '0', '5', '恐怖：无恐怖症状', null, null);
INSERT INTO `can_kao` VALUES ('34', '0', '5', '偏执：无偏执症状', null, null);
INSERT INTO `can_kao` VALUES ('35', '0', '5', '精神病性：无精神病性症状', null, null);
INSERT INTO `can_kao` VALUES ('36', '0', '5', '躯体化：主观躯体感受与临床检查轻度不符，躯体症状伴有一定情绪因素。偶见头晕、紧 绷、胀痛，胃部不适、胀气、嗳气，心跳加快、心慌，疲倦等症。', null, null);
INSERT INTO `can_kao` VALUES ('37', '0', '5', '强迫症状：表现为担心、害怕而反复思考某些念头或想法。有时表现为出现重复动作，如洗手或一些特殊的动作，但时间较短，程度较轻，虽有些痛苦，但尚能工作。', null, null);
INSERT INTO `can_kao` VALUES ('38', '0', '5', '人际关系：性格基础是内向、敏感、胆小、易害羞。心理较脆弱，有时会产生不被理解而痛苦。', null, null);
INSERT INTO `can_kao` VALUES ('39', '0', '5', '抑郁：自我评价稍低，心情欠佳、兴趣下降，偶有烦躁，不愿与人交往，时有睡眠差、多梦。', null, null);
INSERT INTO `can_kao` VALUES ('40', '0', '5', '焦虑：莫名担心，害怕的感觉，可伴心慌、心跳加快，易紧张，多汗，有掩饰举动。', null, null);
INSERT INTO `can_kao` VALUES ('41', '0', '5', '敌对：敏感多疑，怀疑他人动机，警惕性增高，关注他人行为及态度是否友好，易发脾气。', null, null);
INSERT INTO `can_kao` VALUES ('42', '0', '5', '恐怖：独处恐惧感严重，需有人陪伴，特定场所恐怖，不敢与生人交往，尽力克制掩饰，对工作影响不大。', null, null);
INSERT INTO `can_kao` VALUES ('43', '0', '5', '偏执：性格固执，否认。有敌对性，多疑，对他人信任度不足，偶有被跟踪想法。', null, null);
INSERT INTO `can_kao` VALUES ('44', '0', '5', '精神病性：偶有幻听，多为批评、指责、迫害等内容，有被迫害行为妄想，可出现思维被洞悉感，常有敌对性，可有自责倾向，伴有孤独感。 ', null, null);
INSERT INTO `can_kao` VALUES ('45', '0', '5', '躯体化:主观躯体感受与临床检查中度不符，躯体症状伴有明显情绪因素。常有头晕、头胀、紧绷，食欲不振，嗳气，胃胀，心慌、心跳快，胸闷，呼吸急促，疲乏、虚弱等症。', null, null);
INSERT INTO `can_kao` VALUES ('46', '0', '5', '强迫症状：反复重复动作明显增多，或反复思考，自觉无必要，但无法克制，伴明显焦虑，有一定求医行为。强迫思维、强迫行为每日可达３-４小时。', null, null);
INSERT INTO `can_kao` VALUES ('47', '0', '5', '人际关系：很少在生人面前多讲话，表现为敏感、多疑且易害羞。对别人讲话比较留心，常担心别人议论自己，有时对别人有警惕心理状态，做事小心谨慎。', null, null);
INSERT INTO `can_kao` VALUES ('48', '0', '5', '抑郁：自我评价较低，情绪低落明显，常有愁眉苦脸状态，兴趣减退。有时会哭泣或感到活着太累的想法，失眠常见，食欲不振。', null, null);
INSERT INTO `can_kao` VALUES ('49', '0', '5', '焦虑：莫名担心、紧张，无法掩饰的焦虑状态，如心跳、心慌，常有出汗，手指轻微颤抖，有时出现坐立不安。', null, null);
INSERT INTO `can_kao` VALUES ('50', '0', '5', '敌对：警惕性较高，经常注意或怀疑别人的举动，常与人难以相处，偶有破坏性行为。', null, null);
INSERT INTO `can_kao` VALUES ('51', '0', '5', '恐怖：经常采取逃避行为，主要因担心或缺乏安全感，不敢独处，恐惧空间场所，强制去时会出现紧张、焦虑、出汗等症，亦会有心跳加快、心慌等症。', null, null);
INSERT INTO `can_kao` VALUES ('52', '0', '5', '偏执：敏感多疑，认为别人和自己过不去，要迫害自己，对他人的举动都认为与自己相关，有被跟踪感或被监视感。 ', null, null);
INSERT INTO `can_kao` VALUES ('53', '0', '5', '精神病性：常有幻听，内容多为批评、责骂，有时与幻听互相对夸、对骂，认为别人要害他，跟踪他，伴有紧张情绪，有思维被洞悉感，播散感。有自责倾向，时感孤独。     ', null, null);
INSERT INTO `can_kao` VALUES ('54', '0', '5', '躯体化: 主观躯体感受与临床检查重度不符，躯体症状伴有严重情绪因素。常感头晕、头胀、心悸、胸闷气急，窒息感，胃纳差，腹胀，强烈生命恐惧感。', null, null);
INSERT INTO `can_kao` VALUES ('55', '0', '5', '强迫症状：强迫思维或强迫行为每日可达6-8小时，严重影响社会功能和生活功能。明知没必要，但无法抗拒，内心十分痛苦。完成之后，心里有轻松、舒适感，间隔不久，又被焦虑、担心所支配，再次做重复动作。', null, null);
INSERT INTO `can_kao` VALUES ('56', '0', '5', '人际关系：平时很内向，常因过分敏感而少与人讲话，对别人的谈论过度关注，对他人行为呈神经过敏状态，有时采取指责别人的方法，致使朋友极少。', null, null);
INSERT INTO `can_kao` VALUES ('57', '0', '5', '抑郁：自我评价低，常感自己无用，情绪低落明显，整日愁眉不展，自责。有时会产生无助感、绝望感，有消极观念，食欲减退，饮食不振。', null, null);
INSERT INTO `can_kao` VALUES ('58', '0', '5', '焦虑：明显的紧张不安，预感坏事要发生，坐立不安。经常大汗淋漓，心跳加快、心慌、胸闷气短，严重惊恐发作时，可有濒死感。', null, null);
INSERT INTO `can_kao` VALUES ('59', '0', '5', '敌对：疑心严重，甚至怀疑别人采取措施迫害自己。经常发怒，激惹性增强，常以叫骂，摔东西发泄，与人难以相处，甚至连亲人都无法友好相处。', null, null);
INSERT INTO `can_kao` VALUES ('60', '0', '5', '恐怖：对自己所恐怖的对象无法接触，常采取强烈的逃避行为，伴紧张、焦虑，严重时会产生昏厥，甚至有胸闷气急或濒死感，严重影响工作和日常生活。', null, null);
INSERT INTO `can_kao` VALUES ('61', '0', '5', '偏执：不相信他人，常怀疑他人有阴谋迫害行为，被监视感，被跟踪感，经常采取逃避行为，或者紧张、害怕、不敢出门，日常生活受到影响。', null, null);
INSERT INTO `can_kao` VALUES ('62', '0', '5', '精神病性：有幻听，其内容多为批评、责骂，少有表扬，有时沉浸在幻听中，而不与人接触交谈，且伴有明显发呆，喃喃自语，或与幻听对骂，思维被洞悉感，因感到被控制而没有行动自由。可在命令性幻听支配下做出伤人毁物或自伤行为。可有严重自责感、孤独感。', null, null);
INSERT INTO `can_kao` VALUES ('63', '0', '6', '典型的外向（Ｅ分特高）\r\n善于交际，喜欢参加聚会，有许多朋友，健谈，不喜欢独坐静处，学习时好与人讨论，寻求刺激，善于捕捉机会，好出风头，做事急于求成，一般来说属于冲动型；喜欢开玩笑，回答问题脱口而出，不假思索，喜欢环境变化，无忧无虑，不记仇，乐观，常喜笑颜开；好动，总想找些事来做；富于攻击性，但又很容易息怒。总之，他不能时时很好地控制自己的情感，因此，他往往不是一个足以信赖的人。', null, null);
INSERT INTO `can_kao` VALUES ('64', '0', '6', '典型的内向（Ｅ分特低）\r\n表现安静，不喜欢与各种人交往，善于自我省察，对书的兴趣更甚于人，除非对很亲密的朋友，他往往对人有所保留或保持距离；做事之前先订计划，瞻前顾后，不轻举妄动，不喜欢兴奋的事，待人接物严肃，生活有规律；善于控制情感，很少攻击行为，但一旦被激怒很难平复。办事可靠，偏于保守，非常看重道德价值。', null, null);
INSERT INTO `can_kao` VALUES ('65', '0', '6', '典型情绪不稳（Ｎ分特高）\r\n焦虑，紧张，易怒，往往会有抑郁，睡眠不好，患有各种心身障碍。情绪过分，对各种刺激的反应都过于强烈，情绪激发后又很难平复下来。由于强烈的情绪反应而影响了他的正常适应。不可理喻，有时走上危险道路。在与外向结合时，这种人是容易冒火的和不休息的，以至激动、进攻，概括地说，是一个紧张的人，好抱偏见，以至错误。', null, null);
INSERT INTO `can_kao` VALUES ('66', '0', '6', '情绪稳定（Ｎ分很低）\r\n倾向于情绪反应缓慢、轻微，即使激起了情绪也很快平复下来，通常是平静，稳重，性情温和，即使生点气也是有节制的，并且不紧张焦虑。', null, null);
INSERT INTO `can_kao` VALUES ('67', '0', '6', '（Ｐ分高的成人）\r\n独身，不关心人，常有麻烦，在哪里都不合适，可能是残忍的，不人道的，缺乏同情心，感觉迟钝，对人抱敌意，即令是对亲友也如此。进攻，即使是喜爱的人。喜欢一些古怪的不平常的事情，不惧安危，喜恶作剧，总要捣乱。', null, null);
INSERT INTO `can_kao` VALUES ('68', '0', '6', '典型的外向（E得分大于61.5）\r\n善于交际，喜欢参加聚会，有许多朋友，健谈，不喜欢独坐静处，学习时好与人讨论，寻求刺激，善于捕捉机会，好出风头，做事急于求成，一般来说属于冲动型；喜欢开玩笑，回答问题脱口而出，不假思索，喜欢环境变化，无忧无虑，不记仇，乐观，常喜笑颜开；好动，总想找些事来做；富于攻击性，但又很容易息怒。总之，他不能时时很好地控制自己的情感，因此，他往往不是一个足以信赖的人。', null, null);
INSERT INTO `can_kao` VALUES ('69', '0', '6', '典型的内向（E得分小于38.5）\r\n表现安静，不喜欢与各种人交往，善于自我省察，对书的兴趣更甚于人，除非对很亲密的朋友，他往往对人有所保留或保持距离；做事之前先订计划，瞻前顾后，不轻举妄动，不喜欢兴奋的事，待人接物严肃，生活有规律；善于控制情感，很少攻击行为，但一旦被激怒很难平复。办事可靠，偏于保守，非常看重道德价值。', null, null);
INSERT INTO `can_kao` VALUES ('70', '0', '6', '性格中间型（E分在43.3-56.7）\r\n内外倾43.3-56.7属于中间性性格特征，无明显喜欢活动和安静的特点，做事情不冲动但也不过分犹豫不决，态度平淡，热情而不失控，有节而不保守。', null, null);
INSERT INTO `can_kao` VALUES ('71', '0', '6', '倾向外向型（E分56.7-61.5 ）\r\n精神质56.7-61.5提示被试比较孤僻，固执，遇到麻烦较多，对其他人缺乏感情，感觉比较迟钝，很少关心他人，较少有同情心和人道主义精神。有时还会做出不同于一般人的古怪行为。', null, null);
INSERT INTO `can_kao` VALUES ('72', '0', '6', '倾向内向型（E分38.5-43.3 ）\r\n内外倾43.3-56.7属于中间性性格特征，无明显喜欢活动和安静的特点，做事情不冲动但也不过分犹豫不决，态度平淡，热情而不失控，有节而不保守。', null, null);
INSERT INTO `can_kao` VALUES ('73', '0', '6', '典型情绪不稳（Ｎ分大于61.5）\r\n焦虑，紧张，易怒，往往会有抑郁，睡眠不好，患有各种心身障碍。情绪过分，对各种刺激的反应都过于强烈，情绪激发后又很难平复下来。由于强烈的情绪反应而影响了他的正常适应。不可理喻，有时走上危险道路。在与外向结合时，这种人是容易冒火的和不休息的，以至激动、进攻，概括地说，是一个紧张的人，好抱偏见，以至错误。', null, null);
INSERT INTO `can_kao` VALUES ('74', '0', '6', '典型情绪稳定（Ｎ分小于38.5）\r\n倾向于情绪反应缓慢、轻微，即使激起了情绪也很快平复下来，通常是平静，稳重，性情温和，即使生点气也是有节制的，并且不紧张焦虑。', null, null);
INSERT INTO `can_kao` VALUES ('75', '0', '6', '倾向情绪不稳定（N分56.7-61.5）\r\n情绪不稳定，容易紧张、焦虑、发脾气，遇事不冷静，急躁，情绪反应明显，容易感情用事，以感情作为衡量是非的标准，容易与人发生冲突，情绪激动，容易受外界刺激因素的影响。', null, null);
INSERT INTO `can_kao` VALUES ('76', '0', '6', '情绪相对稳定（N分38.5-43.3）\r\n表现为情绪较为平静，很难从外部看出其情绪变化，情绪反应较慢而且强度不大，但绝不冷淡。很少表现紧张、焦虑、不安的症状。', null, null);
INSERT INTO `can_kao` VALUES ('77', '0', '6', '情绪中间型（N分43.3-56.7）\r\n情绪相对稳定，多数情况下能理性判断事物，不会感情用事，也不会过份紧张不安、焦虑，情绪反应适中，能较好控制自己的情绪，容易将激动的情绪状态恢复正常，遇事不容易受到自己情绪状态的左右。', null, null);
INSERT INTO `can_kao` VALUES ('78', '0', '6', '典型精神质（Ｐ得分大于61.5）\r\n独身，不关心人，常有麻烦，在哪里都不合适，可能是残忍的，不人道的，缺乏同情心，感觉迟钝，对人抱敌意，即令是对亲友也如此。进攻，即使是喜爱的人。喜欢一些古怪的不平常的事情，不惧安危，喜恶作剧，总要捣乱。', null, null);
INSERT INTO `can_kao` VALUES ('79', '0', '6', '精神质（P得分小于38.5）\r\n被试人际关系好，在与人交往中能理解和关心他人，能与人友好相处，是非分明，富有同情心，可以给他人提供帮助。', null, null);
INSERT INTO `can_kao` VALUES ('80', '0', '6', '精神质（P分43.3-56.7）\r\n提示被试的精神质在正常范围内，能与其他人正常的交往，无明显固执、古怪、麻烦等表现，能善待其他人，会关心他人，表现出一定的同情心和人道主义精神，人际关系较好。', null, null);
INSERT INTO `can_kao` VALUES ('81', '0', '6', '精神质（P分38.5-43.3）\r\n提示被试无明显的古怪、偏执、冷漠等性格特征，能接纳和理解同伴，富有同情心和人道主义精神，人际关系良好，一般不会表现出古怪的、不平常的行为。', null, null);
INSERT INTO `can_kao` VALUES ('82', '0', '6', '精神质（P分56.7-61.5）\r\n精神质56.7-61.5提示被试比较孤僻，固执，遇到麻烦较多，对其他人缺乏感情，感觉比较迟钝，很少关心他人，较少有同情心和人道主义精神。有时还会做出不同于一般人的古怪行为。', null, null);
INSERT INTO `can_kao` VALUES ('83', '0', '6', '掩饰性（L分大于61.5）\r\n被试存在明显的掩饰倾向，所回答的问题欠真实，很少坦露自己的内心体验，有时表现为高低不一。一般来说，年龄越大，该项测试的得分越高，请根据被试的具体情况具体分析。', null, null);
INSERT INTO `can_kao` VALUES ('84', '0', '6', '掩饰性（L分56.7-61.5）\r\n被试对问题回答真实，具有较高的可信度，无明显的掩饰倾向。', null, null);
INSERT INTO `can_kao` VALUES ('85', '0', '6', '掩饰性（L分43.3-56.7）\r\n掩饰性43.3-56.7 Ｌ：提示被试对问题回答真实，具有较高的可信度，无明显的掩饰倾向。', null, null);
INSERT INTO `can_kao` VALUES ('86', '0', '6', '掩饰性（L分38.5-43.3）\r\n掩饰度38。5-43.3Ｌ：提示被试无掩饰倾向，回答问题真实可信，行为朴实，言行一致，能够坦露自己的内心体验。', null, null);
INSERT INTO `can_kao` VALUES ('87', '0', '6', '掩饰性（L分得分小于38.5）\r\n掩饰性38.5以下Ｌ：提示被试毫无任何掩饰倾向，所回答的问题真实可信，行为纯朴，言行一致，容易坦露自己的内心体验。一般来说，年龄越小，该项得分越低，请根据被试的具体情况具体分析。', null, null);
INSERT INTO `can_kao` VALUES ('88', '0', '7', '总分反映疾病的严重性，总分越高，病情越重。\r\n治疗前后总分值的变化反映疗效的好坏，差值越大疗效越好，治疗前后各症状或症状群的评定变化可反映治疗的靶症状。BPRS的结果可按单项，因子分和总分进行分析。', null, null);
INSERT INTO `can_kao` VALUES ('89', '0', '7', '反映症状的分布和靶症状的严重度。治疗前后的变化可以反映治疗的靶症状变化。因BPRS为分级量表，所以能够比较细致地反映疗效。', null, null);
INSERT INTO `can_kao` VALUES ('90', '0', '7', '反映症状群的分布和疾病的临床特点，并可据此画出症状群廓图。一般归纳为5个因子：', null, null);
INSERT INTO `can_kao` VALUES ('91', '0', '8', '０－５分为无明显躁狂症状；', null, null);
INSERT INTO `can_kao` VALUES ('92', '0', '8', '６－１０分为轻度躁狂症状；', null, null);
INSERT INTO `can_kao` VALUES ('93', '0', '8', '11-21分为中度躁狂症状；', null, null);
INSERT INTO `can_kao` VALUES ('94', '0', '8', '２２分以上为严重躁狂症状。', null, null);
INSERT INTO `can_kao` VALUES ('95', '0', '9', '文盲组16分', null, null);
INSERT INTO `can_kao` VALUES ('96', '0', '9', '小学组（教育年限≤6年）19分', null, null);
INSERT INTO `can_kao` VALUES ('97', '0', '9', '中学或以上组（教育年限＞6年）22分。', null, null);
INSERT INTO `can_kao` VALUES ('101', '0', '10', '痴呆（Dementia）≤10.0分；', null, null);
INSERT INTO `can_kao` VALUES ('102', '0', '10', '可疑痴呆（Pr-dementia）10.5~21.5分；', null, null);
INSERT INTO `can_kao` VALUES ('103', '0', '10', '边缘状态（Sub-normal）22.0~30.5；', null, null);
INSERT INTO `can_kao` VALUES ('104', '0', '10', '正常（Normal）≥31.0。', null, null);
INSERT INTO `can_kao` VALUES ('105', '0', '11', '量表总分：反映阴性症状的严重程度，范围为0～120分。\r\n分量表综合评价总分，即5个分量表的总评项得分的总和，同样能反映阴性症状的严重程度，范围为0～25分。', null, null);
INSERT INTO `can_kao` VALUES ('106', '0', '11', '分量表综合评价：即上述5个分量表总评荐的单项分，用以反映5种具体的阴性症状的严重程度，在治疗和研究中，它们的变化反映靶症状的疗效。', null, null);
INSERT INTO `can_kao` VALUES ('107', '0', '11', '应用量表结果分型：根据结果，可将精神分裂症进一步分型，凡分量表总评项≥3者，称为“突出症状群”，然后根据有关阳性和阴性“突出症状群”及其组合，分为3型：', null, null);
INSERT INTO `can_kao` VALUES ('108', '0', '11', '阳性症状为主型：有一个或多个突出的阳性症状群，无突出的阴性症状群。', null, null);
INSERT INTO `can_kao` VALUES ('109', '0', '11', '阴性症状为主型：有两个或更多的突出的“阴性症状群”无突出的阳性症状群。', null, null);
INSERT INTO `can_kao` VALUES ('110', '0', '11', '混合型：不符合以上两种情况者。', null, null);
INSERT INTO `can_kao` VALUES ('111', '0', '12', '量表总分：反映阳性症状的严重程度，范围为0～170分。\r\n分量表综合评价总分，即4个分量表的总评项得分的总和，同样能反映阴性症状的严重程度，范围为0～20分。', null, null);
INSERT INTO `can_kao` VALUES ('112', '0', '12', '分量表综合评价：即上述4个分量表总评荐的单项分，用以反映4种具体的阳性症状的严重程度，在治疗和研究中，它们的变化反映靶症状的疗效。', null, null);
INSERT INTO `can_kao` VALUES ('113', '0', '12', '应用量表结果分型：根据结果，可将精神分裂症进一步分型，凡分量表总评项≥3者，称为“突出症状群”，然后根据有关阳性和阴性“突出症状群”及其组合，分为3型：', null, null);
INSERT INTO `can_kao` VALUES ('114', '0', '12', '阳性症状为主型：有一个或多个突出的阳性症状群，无突出的阴性症状群。', null, null);
INSERT INTO `can_kao` VALUES ('115', '0', '12', '阴性症状为主型：有两个或更多的突出的“阴性症状群”无突出的阳性症状群。', null, null);
INSERT INTO `can_kao` VALUES ('116', '0', '12', '混合型：不符合以上两种情况者。', null, null);
INSERT INTO `can_kao` VALUES ('117', '0', '13', '无强迫思维与强迫行为：0-5分', null, null);
INSERT INTO `can_kao` VALUES ('118', '0', '13', '轻度严重：6－15分(单纯的强迫思维或强迫行为，仅需要6-9分)   \r\n处于轻度严重的强迫症患者，其症状已经对患者的生活、学习或职业开始造成一定的影响，患者的症状会随着环境和情绪的变化不断的波动，如果不能尽早的解决，很容易会朝着严重的程度发展、泛化，此时是治疗效果最理想的时期，建议尽早治疗。', null, null);
INSERT INTO `can_kao` VALUES ('119', '0', '13', '中度严重：16－25分(单纯的强迫思维或强迫行为，仅需要10-14分)   \r\n这属于中等的强迫症状，表示症状的频率或严重程度已经对生活、学习或职业造成明显的障碍，导致患者可能无法有效执行其原有的角色功能，甚至在没有出现有效的改善前，可能导致抑郁症状，甚至出现自杀念头，必须接受心理治疗或者药物治疗。   ', null, null);
INSERT INTO `can_kao` VALUES ('120', '0', '13', '重度严重：25分以上(单纯的强迫思维或强迫行为，仅需要15分以上)   \r\n此时，患者的强迫症状已经非常严重，完全无法执行原有的角色功能，甚至连衣食住行等生活功能都无法进行。通常患者已经无法出门，将自己禁锢家中，无时无刻都有强迫思考，无时无刻都在执行强迫行为。重度严重的患者极易出现抑郁症状，通常需要强制治疗。', null, null);

-- ----------------------------
-- Table structure for `ce_ping_bao_gao1`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao1`;
CREATE TABLE `ce_ping_bao_gao1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `pingHe` double DEFAULT NULL,
  `qiXu` double DEFAULT NULL,
  `yangXu` double DEFAULT NULL,
  `yinXu` double DEFAULT NULL,
  `tanShi` double DEFAULT NULL,
  `shiRe` double DEFAULT NULL,
  `yuXue` double DEFAULT NULL,
  `qiYu` double DEFAULT NULL,
  `teBing` double DEFAULT NULL,
  `beLong` varchar(255) DEFAULT NULL,
  `yiJian` text,
  `jianYi` text,
  `yaoShan` text,
  `flag` int(11) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao1
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao10`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao10`;
CREATE TABLE `ce_ping_bao_gao10` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `sum` double(11,2) DEFAULT NULL,
  `belong` varchar(255) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao10
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao11`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao11`;
CREATE TABLE `ce_ping_bao_gao11` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `sum` int(11) DEFAULT NULL,
  `qingGanPingDan` int(11) DEFAULT NULL,
  `siWeiPinFa` int(11) DEFAULT NULL,
  `yiZhiQueFa` int(11) DEFAULT NULL,
  `xingQuSheJiao` int(11) DEFAULT NULL,
  `zhuYiZhangAi` int(11) DEFAULT NULL,
  `show` varchar(255) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao11
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao12`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao12`;
CREATE TABLE `ce_ping_bao_gao12` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `huanJue` int(11) DEFAULT NULL,
  `wangXiang` int(11) DEFAULT NULL,
  `GuaiYiXingWei` int(11) DEFAULT NULL,
  `yangXingSiWei` int(11) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `show` varchar(255) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao12
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao13`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao13`;
CREATE TABLE `ce_ping_bao_gao13` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `siWei` int(11) DEFAULT NULL,
  `xingWei` int(11) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `zhiDaoYiJian` varchar(255) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao13
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao14`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao14`;
CREATE TABLE `ce_ping_bao_gao14` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `sum` int(11) DEFAULT NULL,
  `yiJian` varchar(255) DEFAULT NULL,
  `jianYi` varchar(255) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao14
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao15`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao15`;
CREATE TABLE `ce_ping_bao_gao15` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `sum` int(11) DEFAULT NULL,
  `belong` varchar(255) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao15
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao2`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao2`;
CREATE TABLE `ce_ping_bao_gao2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `result` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `belong` varchar(255) DEFAULT NULL,
  `yiJian` text,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao2
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao3`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao3`;
CREATE TABLE `ce_ping_bao_gao3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `result` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `belong` varchar(255) DEFAULT NULL,
  `yiJian` text,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao3
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao4`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao4`;
CREATE TABLE `ce_ping_bao_gao4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `yiZhia0` int(11) DEFAULT NULL,
  `jiReb0` int(11) DEFAULT NULL,
  `shengWuc0` int(11) DEFAULT NULL,
  `renZhid0` int(11) DEFAULT NULL,
  `xiangXiange0` int(11) DEFAULT NULL,
  `yiZhia` double DEFAULT NULL,
  `jiReb` double DEFAULT NULL,
  `shengWuc` double DEFAULT NULL,
  `belong1` varchar(255) DEFAULT NULL,
  `belong2` varchar(255) DEFAULT NULL,
  `renZhid` double DEFAULT NULL,
  `xiangXiange` double DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  `yiJian1` varchar(255) DEFAULT NULL,
  `yiJian2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao4
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao5`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao5`;
CREATE TABLE `ce_ping_bao_gao5` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `quTiHua0` int(11) DEFAULT NULL,
  `qiangPoZheng0` int(11) DEFAULT NULL,
  `renJiGuanXi0` int(11) DEFAULT NULL,
  `yiYu0` int(11) DEFAULT NULL,
  `jiaoLv0` int(11) DEFAULT NULL,
  `diDui0` int(11) DEFAULT NULL,
  `kongBu0` int(11) DEFAULT NULL,
  `pianZhi0` int(11) DEFAULT NULL,
  `jingShenBing0` int(11) DEFAULT NULL,
  `qiTa0` int(11) DEFAULT NULL,
  `quTiHua` double(11,2) DEFAULT NULL,
  `qiangPoZheng` double(11,2) DEFAULT NULL,
  `renJiGuanXi` double(11,2) DEFAULT NULL,
  `yiYu` double(11,2) DEFAULT NULL,
  `jiaoLv` double(11,2) DEFAULT NULL,
  `diDui` double(11,2) DEFAULT NULL,
  `kongBu` double(11,2) DEFAULT NULL,
  `pianZhi` double(11,2) DEFAULT NULL,
  `jingShenBing` double(11,2) DEFAULT NULL,
  `qiTa` double(11,2) DEFAULT NULL,
  `belongQuTiHua` text,
  `sum` int(11) DEFAULT NULL,
  `belongQiangPoZheng` text,
  `belongRenJiGuanXi` text,
  `belongYiYu` text,
  `belongJiaoLv` text,
  `belongDiDui` text,
  `belongKongBu` text,
  `belongPianZhi` text,
  `belongJingShenBing` text,
  `belongQiTa` text,
  `ave` double(11,2) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  `belongQuTiHua0` varchar(255) DEFAULT NULL,
  `belongQiangPoZheng0` varchar(255) DEFAULT NULL,
  `belongRenJiGuanXi0` varchar(255) DEFAULT NULL,
  `belongYiYu0` varchar(255) DEFAULT NULL,
  `belongJiaoLv0` varchar(255) DEFAULT NULL,
  `belongDiDui0` varchar(255) DEFAULT NULL,
  `belongKongBu0` varchar(255) DEFAULT NULL,
  `belongPianZhi0` varchar(255) DEFAULT NULL,
  `belongJingShenBing0` varchar(255) DEFAULT NULL,
  `belongQiTa0` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao5
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao6`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao6`;
CREATE TABLE `ce_ping_bao_gao6` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `P` double(11,2) DEFAULT NULL,
  `E` double(11,2) DEFAULT NULL,
  `N` double(11,2) DEFAULT NULL,
  `L` double(11,2) DEFAULT NULL,
  `yiJianP` varchar(255) DEFAULT NULL,
  `yiJianE` varchar(255) DEFAULT NULL,
  `yiJianN` varchar(255) DEFAULT NULL,
  `yiJianL` varchar(255) DEFAULT NULL,
  `belongP` varchar(255) DEFAULT NULL,
  `belongE` varchar(255) DEFAULT NULL,
  `belongN` varchar(255) DEFAULT NULL,
  `belongL` varchar(255) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  `Py` double(11,2) DEFAULT NULL,
  `Ey` double(11,2) DEFAULT NULL,
  `Ny` double(11,2) DEFAULT NULL,
  `Ly` double(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao6
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao7`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao7`;
CREATE TABLE `ce_ping_bao_gao7` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `sum` int(11) DEFAULT NULL,
  `jiaoLvYouLv` double(11,2) DEFAULT NULL,
  `queFaHuoLi` double(11,2) DEFAULT NULL,
  `siWeiZhangAi` double(11,2) DEFAULT NULL,
  `jiHuoXing` double(11,2) DEFAULT NULL,
  `diDuiCaiYi` double(11,2) DEFAULT NULL,
  `riQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao7
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao8`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao8`;
CREATE TABLE `ce_ping_bao_gao8` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `riQi` datetime DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `yiJian` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao8
-- ----------------------------

-- ----------------------------
-- Table structure for `ce_ping_bao_gao9`
-- ----------------------------
DROP TABLE IF EXISTS `ce_ping_bao_gao9`;
CREATE TABLE `ce_ping_bao_gao9` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `riQi` datetime DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `yiJian` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ce_ping_bao_gao9
-- ----------------------------

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `city_id` int(10) NOT NULL,
  `city_name` varchar(50) NOT NULL,
  `province_id` varchar(20) NOT NULL,
  `first_letter` varchar(20) DEFAULT NULL,
  `is_hot` int(10) NOT NULL DEFAULT '0',
  `state` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`city_id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('110100', '北京(市辖区)', '110000', 'bj', '0', '1');
INSERT INTO `city` VALUES ('110200', '北京(县)', '110000', 'bj', '0', '1');
INSERT INTO `city` VALUES ('120100', '天津(市辖区)', '120000', 'tj', '0', '1');
INSERT INTO `city` VALUES ('120200', '天津(县)', '120000', 'tj', '0', '1');
INSERT INTO `city` VALUES ('130100', '石家庄市', '130000', 'sjz', '0', '1');
INSERT INTO `city` VALUES ('130200', '唐山市', '130000', 'ts', '0', '1');
INSERT INTO `city` VALUES ('130300', '秦皇岛市', '130000', 'qhd', '0', '1');
INSERT INTO `city` VALUES ('130400', '邯郸市', '130000', 'hd', '0', '1');
INSERT INTO `city` VALUES ('130500', '邢台市', '130000', 'xt', '0', '1');
INSERT INTO `city` VALUES ('130600', '保定市', '130000', 'bd', '0', '1');
INSERT INTO `city` VALUES ('130700', '张家口市', '130000', 'zjk', '0', '1');
INSERT INTO `city` VALUES ('130800', '承德市', '130000', 'cd', '0', '1');
INSERT INTO `city` VALUES ('130900', '沧州市', '130000', 'cz', '0', '1');
INSERT INTO `city` VALUES ('131000', '廊坊市', '130000', 'lf', '0', '1');
INSERT INTO `city` VALUES ('131100', '衡水市', '130000', 'hs', '0', '1');
INSERT INTO `city` VALUES ('140100', '太原市', '140000', 'ty', '0', '1');
INSERT INTO `city` VALUES ('140200', '大同市', '140000', 'dt', '0', '1');
INSERT INTO `city` VALUES ('140300', '阳泉市', '140000', 'yq', '0', '1');
INSERT INTO `city` VALUES ('140400', '长治市', '140000', 'cz', '0', '1');
INSERT INTO `city` VALUES ('140500', '晋城市', '140000', 'zc', '0', '1');
INSERT INTO `city` VALUES ('140600', '朔州市', '140000', 'sz', '0', '1');
INSERT INTO `city` VALUES ('140700', '晋中市', '140000', 'jz', '0', '1');
INSERT INTO `city` VALUES ('140800', '运城市', '140000', 'yc', '0', '1');
INSERT INTO `city` VALUES ('140900', '忻州市', '140000', 'xz', '0', '1');
INSERT INTO `city` VALUES ('141000', '临汾市', '140000', 'll', '0', '1');
INSERT INTO `city` VALUES ('141100', '吕梁市', '140000', 'll', '0', '1');
INSERT INTO `city` VALUES ('150100', '呼和浩特市', '150000', 'hh', '0', '1');
INSERT INTO `city` VALUES ('150200', '包头市', '150000', 'bt', '0', '1');
INSERT INTO `city` VALUES ('150300', '乌海市', '150000', 'wh', '0', '1');
INSERT INTO `city` VALUES ('150400', '赤峰市', '150000', 'cf', '0', '1');
INSERT INTO `city` VALUES ('150500', '通辽市', '150000', 'tl', '0', '1');
INSERT INTO `city` VALUES ('150600', '鄂尔多斯市', '150000', 'ee', '0', '1');
INSERT INTO `city` VALUES ('150700', '呼伦贝尔市', '150000', 'hl', '0', '1');
INSERT INTO `city` VALUES ('150800', '巴彦淖尔市', '150000', 'by', '0', '1');
INSERT INTO `city` VALUES ('150900', '乌兰察布市', '150000', 'wl', '0', '1');
INSERT INTO `city` VALUES ('152200', '兴安盟', '150000', 'xa', '0', '1');
INSERT INTO `city` VALUES ('152500', '锡林郭勒盟', '150000', 'xl', '0', '1');
INSERT INTO `city` VALUES ('152900', '阿拉善盟', '150000', 'al', '0', '1');
INSERT INTO `city` VALUES ('210100', '沈阳市', '210000', 'sy', '1', '1');
INSERT INTO `city` VALUES ('210200', '大连市', '210000', 'dl', '1', '1');
INSERT INTO `city` VALUES ('210300', '鞍山市', '210000', 'as', '0', '1');
INSERT INTO `city` VALUES ('210400', '抚顺市', '210000', 'fs', '0', '1');
INSERT INTO `city` VALUES ('210500', '本溪市', '210000', 'bx', '0', '1');
INSERT INTO `city` VALUES ('210600', '丹东市', '210000', 'dd', '0', '1');
INSERT INTO `city` VALUES ('210700', '锦州市', '210000', 'jz', '0', '1');
INSERT INTO `city` VALUES ('210800', '营口市', '210000', 'yk', '0', '1');
INSERT INTO `city` VALUES ('210900', '阜新市', '210000', 'fx', '0', '1');
INSERT INTO `city` VALUES ('211000', '辽阳市', '210000', 'ly', '0', '1');
INSERT INTO `city` VALUES ('211100', '盘锦市', '210000', 'pj', '0', '1');
INSERT INTO `city` VALUES ('211200', '铁岭市', '210000', 'tl', '0', '1');
INSERT INTO `city` VALUES ('211300', '朝阳市', '210000', 'cy', '0', '1');
INSERT INTO `city` VALUES ('211400', '葫芦岛市', '210000', 'hld', '0', '1');
INSERT INTO `city` VALUES ('220100', '长春市', '220000', 'cc', '0', '1');
INSERT INTO `city` VALUES ('220200', '吉林市', '220000', 'jl', '0', '1');
INSERT INTO `city` VALUES ('220300', '四平市', '220000', 'sp', '0', '1');
INSERT INTO `city` VALUES ('220400', '辽源市', '220000', 'ly', '0', '1');
INSERT INTO `city` VALUES ('220500', '通化市', '220000', 'th', '0', '1');
INSERT INTO `city` VALUES ('220600', '白山市', '220000', 'bs', '0', '1');
INSERT INTO `city` VALUES ('220700', '松原市', '220000', 'sy', '0', '1');
INSERT INTO `city` VALUES ('220800', '白城市', '220000', 'bc', '0', '1');
INSERT INTO `city` VALUES ('222400', '延边朝鲜族自治州', '220000', 'yb', '0', '1');
INSERT INTO `city` VALUES ('230100', '哈尔滨市', '230000', 'heb', '0', '1');
INSERT INTO `city` VALUES ('230200', '齐齐哈尔市', '230000', 'qq', '0', '1');
INSERT INTO `city` VALUES ('230300', '鸡西市', '230000', 'jx', '0', '1');
INSERT INTO `city` VALUES ('230400', '鹤岗市', '230000', 'hg', '0', '1');
INSERT INTO `city` VALUES ('230500', '双鸭山市', '230000', 'sy', '0', '1');
INSERT INTO `city` VALUES ('230600', '大庆市', '230000', 'dq', '0', '1');
INSERT INTO `city` VALUES ('230700', '伊春市', '230000', 'yc', '0', '1');
INSERT INTO `city` VALUES ('230800', '佳木斯市', '230000', 'jms', '0', '1');
INSERT INTO `city` VALUES ('230900', '七台河市', '230000', 'qth', '0', '1');
INSERT INTO `city` VALUES ('231000', '牡丹江市', '230000', 'mdj', '0', '1');
INSERT INTO `city` VALUES ('231100', '黑河市', '230000', 'hh', '0', '1');
INSERT INTO `city` VALUES ('231200', '绥化市', '230000', 'sh', '0', '1');
INSERT INTO `city` VALUES ('232700', '大兴安岭地区', '230000', 'dxal', '0', '1');
INSERT INTO `city` VALUES ('310100', '上海(市辖区)', '310000', 'sh', '0', '1');
INSERT INTO `city` VALUES ('310200', '上海(县)', '310000', 'sh', '0', '1');
INSERT INTO `city` VALUES ('320100', '南京市', '320000', 'nj', '0', '1');
INSERT INTO `city` VALUES ('320200', '无锡市', '320000', 'wx', '0', '1');
INSERT INTO `city` VALUES ('320300', '徐州市', '320000', 'xz', '0', '1');
INSERT INTO `city` VALUES ('320400', '常州市', '320000', 'cz', '0', '1');
INSERT INTO `city` VALUES ('320500', '苏州市', '320000', 'sz', '0', '1');
INSERT INTO `city` VALUES ('320600', '南通市', '320000', 'nt', '0', '1');
INSERT INTO `city` VALUES ('320700', '连云港市', '320000', 'lyg', '0', '1');
INSERT INTO `city` VALUES ('320800', '淮安市', '320000', 'ha', '0', '1');
INSERT INTO `city` VALUES ('320900', '盐城市', '320000', 'yc', '0', '1');
INSERT INTO `city` VALUES ('321000', '扬州市', '320000', 'yz', '0', '1');
INSERT INTO `city` VALUES ('321100', '镇江市', '320000', 'zj', '0', '1');
INSERT INTO `city` VALUES ('321200', '泰州市', '320000', 'tz', '0', '1');
INSERT INTO `city` VALUES ('321300', '宿迁市', '320000', 'sq', '0', '1');
INSERT INTO `city` VALUES ('330100', '杭州市', '330000', 'hz', '0', '1');
INSERT INTO `city` VALUES ('330200', '宁波市', '330000', 'nb', '0', '1');
INSERT INTO `city` VALUES ('330300', '温州市', '330000', 'wz', '0', '1');
INSERT INTO `city` VALUES ('330400', '嘉兴市', '330000', 'jx', '0', '1');
INSERT INTO `city` VALUES ('330500', '湖州市', '330000', 'hz', '0', '1');
INSERT INTO `city` VALUES ('330600', '绍兴市', '330000', 'sx', '0', '1');
INSERT INTO `city` VALUES ('330700', '金华市', '330000', 'jh', '0', '1');
INSERT INTO `city` VALUES ('330800', '衢州市', '330000', 'hz', '0', '1');
INSERT INTO `city` VALUES ('330900', '舟山市', '330000', 'zs', '0', '1');
INSERT INTO `city` VALUES ('331000', '台州市', '330000', 'tz', '0', '1');
INSERT INTO `city` VALUES ('331100', '丽水市', '330000', 'ls', '0', '1');
INSERT INTO `city` VALUES ('340100', '合肥市', '340000', 'hf', '0', '1');
INSERT INTO `city` VALUES ('340200', '芜湖市', '340000', 'wh', '0', '1');
INSERT INTO `city` VALUES ('340300', '蚌埠市', '340000', 'bb', '0', '1');
INSERT INTO `city` VALUES ('340400', '淮南市', '340000', 'hn', '0', '1');
INSERT INTO `city` VALUES ('340500', '马鞍山市', '340000', 'mas', '0', '1');
INSERT INTO `city` VALUES ('340600', '淮北市', '340000', 'hb', '0', '1');
INSERT INTO `city` VALUES ('340700', '铜陵市', '340000', 'tl', '0', '1');
INSERT INTO `city` VALUES ('340800', '安庆市', '340000', 'aq', '0', '1');
INSERT INTO `city` VALUES ('341000', '黄山市', '340000', 'hs', '0', '1');
INSERT INTO `city` VALUES ('341100', '滁州市', '340000', 'cz', '0', '1');
INSERT INTO `city` VALUES ('341200', '阜阳市', '340000', 'fy', '0', '1');
INSERT INTO `city` VALUES ('341300', '宿州市', '340000', 'sz', '0', '1');
INSERT INTO `city` VALUES ('341400', '巢湖市', '340000', 'ch', '0', '1');
INSERT INTO `city` VALUES ('341500', '六安市', '340000', 'la', '0', '1');
INSERT INTO `city` VALUES ('341600', '亳州市', '340000', 'hz', '0', '1');
INSERT INTO `city` VALUES ('341700', '池州市', '340000', 'cz', '0', '1');
INSERT INTO `city` VALUES ('341800', '宣城市', '340000', 'xc', '0', '1');
INSERT INTO `city` VALUES ('350100', '福州市', '350000', 'fz', '0', '1');
INSERT INTO `city` VALUES ('350200', '厦门市', '350000', 'xm', '0', '1');
INSERT INTO `city` VALUES ('350300', '莆田市', '350000', 'ft', '0', '1');
INSERT INTO `city` VALUES ('350400', '三明市', '350000', 'sm', '0', '1');
INSERT INTO `city` VALUES ('350500', '泉州市', '350000', 'qz', '0', '1');
INSERT INTO `city` VALUES ('350600', '漳州市', '350000', 'zz', '0', '1');
INSERT INTO `city` VALUES ('350700', '南平市', '350000', 'np', '0', '1');
INSERT INTO `city` VALUES ('350800', '龙岩市', '350000', 'ly', '0', '1');
INSERT INTO `city` VALUES ('350900', '宁德市', '350000', 'nd', '0', '1');
INSERT INTO `city` VALUES ('360100', '南昌市', '360000', 'nc', '0', '1');
INSERT INTO `city` VALUES ('360200', '景德镇市', '360000', 'jdz', '0', '1');
INSERT INTO `city` VALUES ('360300', '萍乡市', '360000', 'px', '0', '1');
INSERT INTO `city` VALUES ('360400', '九江市', '360000', 'jj', '0', '1');
INSERT INTO `city` VALUES ('360500', '新余市', '360000', 'xy', '0', '1');
INSERT INTO `city` VALUES ('360600', '鹰潭市', '360000', 'yt', '0', '1');
INSERT INTO `city` VALUES ('360700', '赣州市', '360000', 'gz', '0', '1');
INSERT INTO `city` VALUES ('360800', '吉安市', '360000', 'ja', '0', '1');
INSERT INTO `city` VALUES ('360900', '宜春市', '360000', 'yc', '0', '1');
INSERT INTO `city` VALUES ('361000', '抚州市', '360000', 'fz', '0', '1');
INSERT INTO `city` VALUES ('361100', '上饶市', '360000', 'sx', '0', '1');
INSERT INTO `city` VALUES ('370100', '济南市', '370000', 'jn', '0', '1');
INSERT INTO `city` VALUES ('370200', '青岛市', '370000', 'qd', '0', '1');
INSERT INTO `city` VALUES ('370300', '淄博市', '370000', 'zb', '0', '1');
INSERT INTO `city` VALUES ('370400', '枣庄市', '370000', 'zz', '0', '1');
INSERT INTO `city` VALUES ('370500', '东营市', '370000', 'dy', '0', '1');
INSERT INTO `city` VALUES ('370600', '烟台市', '370000', 'yt', '0', '1');
INSERT INTO `city` VALUES ('370700', '潍坊市', '370000', 'lf', '0', '1');
INSERT INTO `city` VALUES ('370800', '济宁市', '370000', 'jn', '0', '1');
INSERT INTO `city` VALUES ('370900', '泰安市', '370000', 'ta', '0', '1');
INSERT INTO `city` VALUES ('371000', '威海市', '370000', 'wh', '0', '1');
INSERT INTO `city` VALUES ('371100', '日照市', '370000', 'rz', '0', '1');
INSERT INTO `city` VALUES ('371200', '莱芜市', '370000', 'lw', '0', '1');
INSERT INTO `city` VALUES ('371300', '临沂市', '370000', 'ly', '0', '1');
INSERT INTO `city` VALUES ('371400', '德州市', '370000', 'dz', '0', '1');
INSERT INTO `city` VALUES ('371500', '聊城市', '370000', 'lc', '0', '1');
INSERT INTO `city` VALUES ('371600', '滨州市', '370000', 'bz', '0', '1');
INSERT INTO `city` VALUES ('371700', '荷泽市', '370000', 'hz', '0', '1');
INSERT INTO `city` VALUES ('410100', '郑州市', '410000', 'zz', '0', '1');
INSERT INTO `city` VALUES ('410200', '开封市', '410000', 'kf', '0', '1');
INSERT INTO `city` VALUES ('410300', '洛阳市', '410000', 'ly', '0', '1');
INSERT INTO `city` VALUES ('410400', '平顶山市', '410000', 'pds', '0', '1');
INSERT INTO `city` VALUES ('410500', '安阳市', '410000', 'ay', '0', '1');
INSERT INTO `city` VALUES ('410600', '鹤壁市', '410000', 'hb', '0', '1');
INSERT INTO `city` VALUES ('410700', '新乡市', '410000', 'xx', '0', '1');
INSERT INTO `city` VALUES ('410800', '焦作市', '410000', 'jz', '0', '1');
INSERT INTO `city` VALUES ('410900', '濮阳市', '410000', 'py', '0', '1');
INSERT INTO `city` VALUES ('411000', '许昌市', '410000', 'xc', '0', '1');
INSERT INTO `city` VALUES ('411100', '漯河市', '410000', 'lh', '0', '1');
INSERT INTO `city` VALUES ('411200', '三门峡市', '410000', 'smx', '0', '1');
INSERT INTO `city` VALUES ('411300', '南阳市', '410000', 'ny', '0', '1');
INSERT INTO `city` VALUES ('411400', '商丘市', '410000', 'sq', '0', '1');
INSERT INTO `city` VALUES ('411500', '信阳市', '410000', 'xy', '0', '1');
INSERT INTO `city` VALUES ('411600', '周口市', '410000', 'zk', '0', '1');
INSERT INTO `city` VALUES ('411700', '驻马店市', '410000', 'zmd', '0', '1');
INSERT INTO `city` VALUES ('420100', '武汉市', '420000', 'wh', '0', '1');
INSERT INTO `city` VALUES ('420200', '黄石市', '420000', 'hs', '0', '1');
INSERT INTO `city` VALUES ('420300', '十堰市', '420000', 'sy', '0', '1');
INSERT INTO `city` VALUES ('420500', '宜昌市', '420000', 'yc', '0', '1');
INSERT INTO `city` VALUES ('420600', '襄樊市', '420000', 'xf', '0', '1');
INSERT INTO `city` VALUES ('420700', '鄂州市', '420000', 'ez', '0', '1');
INSERT INTO `city` VALUES ('420800', '荆门市', '420000', 'xm', '0', '1');
INSERT INTO `city` VALUES ('420900', '孝感市', '420000', 'xg', '0', '1');
INSERT INTO `city` VALUES ('421000', '荆州市', '420000', 'zj', '0', '1');
INSERT INTO `city` VALUES ('421100', '黄冈市', '420000', 'hg', '0', '1');
INSERT INTO `city` VALUES ('421200', '咸宁市', '420000', 'xn', '0', '1');
INSERT INTO `city` VALUES ('421300', '随州市', '420000', 'sz', '0', '1');
INSERT INTO `city` VALUES ('422800', '恩施土家族苗族自治州', '420000', 'es', '0', '1');
INSERT INTO `city` VALUES ('429000', '省直辖行政单位', '420000', 'sz', '0', '1');
INSERT INTO `city` VALUES ('430100', '长沙市', '430000', 'cs', '0', '1');
INSERT INTO `city` VALUES ('430200', '株洲市', '430000', 'zz', '0', '1');
INSERT INTO `city` VALUES ('430300', '湘潭市', '430000', 'xt', '0', '1');
INSERT INTO `city` VALUES ('430400', '衡阳市', '430000', 'hy', '0', '1');
INSERT INTO `city` VALUES ('430500', '邵阳市', '430000', 'sy', '0', '1');
INSERT INTO `city` VALUES ('430600', '岳阳市', '430000', 'yy', '0', '1');
INSERT INTO `city` VALUES ('430700', '常德市', '430000', 'cd', '0', '1');
INSERT INTO `city` VALUES ('430800', '张家界市', '430000', 'zjj', '0', '1');
INSERT INTO `city` VALUES ('430900', '益阳市', '430000', 'yy', '0', '1');
INSERT INTO `city` VALUES ('431000', '郴州市', '430000', 'cz', '0', '1');
INSERT INTO `city` VALUES ('431100', '永州市', '430000', 'yz', '0', '1');
INSERT INTO `city` VALUES ('431200', '怀化市', '430000', 'hh', '0', '1');
INSERT INTO `city` VALUES ('431300', '娄底市', '430000', 'ld', '0', '1');
INSERT INTO `city` VALUES ('433100', '湘西土家族苗族自治州', '430000', 'xx', '0', '1');
INSERT INTO `city` VALUES ('440100', '广州市', '440000', 'gz', '0', '1');
INSERT INTO `city` VALUES ('440200', '韶关市', '440000', 'sg', '0', '1');
INSERT INTO `city` VALUES ('440300', '深圳市', '440000', 'sz', '0', '1');
INSERT INTO `city` VALUES ('440400', '珠海市', '440000', 'zh', '0', '1');
INSERT INTO `city` VALUES ('440500', '汕头市', '440000', 'st', '0', '1');
INSERT INTO `city` VALUES ('440600', '佛山市', '440000', 'fs', '0', '1');
INSERT INTO `city` VALUES ('440700', '江门市', '440000', 'jm', '0', '1');
INSERT INTO `city` VALUES ('440800', '湛江市', '440000', 'zj', '0', '1');
INSERT INTO `city` VALUES ('440900', '茂名市', '440000', 'mm', '0', '1');
INSERT INTO `city` VALUES ('441200', '肇庆市', '440000', 'zq', '0', '1');
INSERT INTO `city` VALUES ('441300', '惠州市', '440000', 'hz', '0', '1');
INSERT INTO `city` VALUES ('441400', '梅州市', '440000', 'mz', '0', '1');
INSERT INTO `city` VALUES ('441500', '汕尾市', '440000', 'sw', '0', '1');
INSERT INTO `city` VALUES ('441600', '河源市', '440000', 'hy', '0', '1');
INSERT INTO `city` VALUES ('441700', '阳江市', '440000', 'yj', '0', '1');
INSERT INTO `city` VALUES ('441800', '清远市', '440000', 'qy', '0', '1');
INSERT INTO `city` VALUES ('441900', '东莞市', '440000', 'dw', '0', '1');
INSERT INTO `city` VALUES ('442000', '中山市', '440000', 'zs', '0', '1');
INSERT INTO `city` VALUES ('445100', '潮州市', '440000', 'cz', '0', '1');
INSERT INTO `city` VALUES ('445200', '揭阳市', '440000', 'jy', '0', '1');
INSERT INTO `city` VALUES ('445300', '云浮市', '440000', 'yf', '0', '1');
INSERT INTO `city` VALUES ('450100', '南宁市', '450000', 'nn', '0', '1');
INSERT INTO `city` VALUES ('450200', '柳州市', '450000', 'lz', '0', '1');
INSERT INTO `city` VALUES ('450300', '桂林市', '450000', 'gl', '0', '1');
INSERT INTO `city` VALUES ('450400', '梧州市', '450000', 'wz', '0', '1');
INSERT INTO `city` VALUES ('450500', '北海市', '450000', 'bh', '0', '1');
INSERT INTO `city` VALUES ('450600', '防城港市', '450000', 'fc', '0', '1');
INSERT INTO `city` VALUES ('450700', '钦州市', '450000', 'rz', '0', '1');
INSERT INTO `city` VALUES ('450800', '贵港市', '450000', 'gg', '0', '1');
INSERT INTO `city` VALUES ('450900', '玉林市', '450000', 'yl', '0', '1');
INSERT INTO `city` VALUES ('451000', '百色市', '450000', 'bs', '0', '1');
INSERT INTO `city` VALUES ('451100', '贺州市', '450000', 'hz', '0', '1');
INSERT INTO `city` VALUES ('451200', '河池市', '450000', 'hc', '0', '1');
INSERT INTO `city` VALUES ('451300', '来宾市', '450000', 'lb', '0', '1');
INSERT INTO `city` VALUES ('451400', '崇左市', '450000', 'cz', '0', '1');
INSERT INTO `city` VALUES ('460100', '海口市', '460000', 'hk', '0', '1');
INSERT INTO `city` VALUES ('460200', '三亚市', '460000', 'sy', '0', '1');
INSERT INTO `city` VALUES ('469000', '省直辖县级行政单位', '460000', 'sz', '0', '1');
INSERT INTO `city` VALUES ('500100', '重庆(市辖区)', '500000', 'cq', '0', '1');
INSERT INTO `city` VALUES ('500200', '重庆(县)', '500000', 'cq', '0', '1');
INSERT INTO `city` VALUES ('500300', '重庆(市)', '500000', 'cq', '0', '1');
INSERT INTO `city` VALUES ('510100', '成都市', '510000', 'cd', '0', '1');
INSERT INTO `city` VALUES ('510300', '自贡市', '510000', 'zg', '0', '1');
INSERT INTO `city` VALUES ('510400', '攀枝花市', '510000', 'pzh', '0', '1');
INSERT INTO `city` VALUES ('510500', '泸州市', '510000', 'lz', '0', '1');
INSERT INTO `city` VALUES ('510600', '德阳市', '510000', 'dy', '0', '1');
INSERT INTO `city` VALUES ('510700', '绵阳市', '510000', 'jy', '0', '1');
INSERT INTO `city` VALUES ('510800', '广元市', '510000', 'gy', '0', '1');
INSERT INTO `city` VALUES ('510900', '遂宁市', '510000', 'sn', '0', '1');
INSERT INTO `city` VALUES ('511000', '内江市', '510000', 'nj', '0', '1');
INSERT INTO `city` VALUES ('511100', '乐山市', '510000', 'ls', '0', '1');
INSERT INTO `city` VALUES ('511300', '南充市', '510000', 'nc', '0', '1');
INSERT INTO `city` VALUES ('511400', '眉山市', '510000', 'ms', '0', '1');
INSERT INTO `city` VALUES ('511500', '宜宾市', '510000', 'yb', '0', '1');
INSERT INTO `city` VALUES ('511600', '广安市', '510000', 'ga', '0', '1');
INSERT INTO `city` VALUES ('511700', '达州市', '510000', 'dz', '0', '1');
INSERT INTO `city` VALUES ('511800', '雅安市', '510000', 'ya', '0', '1');
INSERT INTO `city` VALUES ('511900', '巴中市', '510000', 'bz', '0', '1');
INSERT INTO `city` VALUES ('512000', '资阳市', '510000', 'zy', '0', '1');
INSERT INTO `city` VALUES ('513200', '阿坝藏族羌族自治州', '510000', 'ab', '0', '1');
INSERT INTO `city` VALUES ('513300', '甘孜藏族自治州', '510000', 'gm', '0', '1');
INSERT INTO `city` VALUES ('513400', '凉山彝族自治州', '510000', 'ls', '0', '1');
INSERT INTO `city` VALUES ('520100', '贵阳市', '520000', 'gy', '0', '1');
INSERT INTO `city` VALUES ('520200', '六盘水市', '520000', 'lp', '0', '1');
INSERT INTO `city` VALUES ('520300', '遵义市', '520000', 'zy', '0', '1');
INSERT INTO `city` VALUES ('520400', '安顺市', '520000', 'as', '0', '1');
INSERT INTO `city` VALUES ('522200', '铜仁地区', '520000', 'tr', '0', '1');
INSERT INTO `city` VALUES ('522300', '黔西南布依族苗族自治州', '520000', 'jx', '0', '1');
INSERT INTO `city` VALUES ('522400', '毕节地区', '520000', 'bj', '0', '1');
INSERT INTO `city` VALUES ('522600', '黔东南苗族侗族自治州', '520000', 'jd', '0', '1');
INSERT INTO `city` VALUES ('522700', '黔南布依族苗族自治州', '520000', 'jn', '0', '1');
INSERT INTO `city` VALUES ('530100', '昆明市', '530000', 'km', '0', '1');
INSERT INTO `city` VALUES ('530300', '曲靖市', '530000', 'qj', '0', '1');
INSERT INTO `city` VALUES ('530400', '玉溪市', '530000', 'yx', '0', '1');
INSERT INTO `city` VALUES ('530500', '保山市', '530000', 'bs', '0', '1');
INSERT INTO `city` VALUES ('530600', '昭通市', '530000', 'zt', '0', '1');
INSERT INTO `city` VALUES ('530700', '丽江市', '530000', 'lj', '0', '1');
INSERT INTO `city` VALUES ('530800', '思茅市', '530000', 'sm', '0', '1');
INSERT INTO `city` VALUES ('530900', '临沧市', '530000', 'lc', '0', '1');
INSERT INTO `city` VALUES ('532300', '楚雄彝族自治州', '530000', 'cx', '0', '1');
INSERT INTO `city` VALUES ('532500', '红河哈尼族彝族自治州', '530000', 'hh', '0', '1');
INSERT INTO `city` VALUES ('532600', '文山壮族苗族自治州', '530000', 'ws', '0', '1');
INSERT INTO `city` VALUES ('532800', '西双版纳傣族自治州', '530000', 'xs', '0', '1');
INSERT INTO `city` VALUES ('532900', '大理白族自治州', '530000', 'dl', '0', '1');
INSERT INTO `city` VALUES ('533100', '德宏傣族景颇族自治州', '530000', 'dh', '0', '1');
INSERT INTO `city` VALUES ('533300', '怒江傈僳族自治州', '530000', 'nj', '0', '1');
INSERT INTO `city` VALUES ('533400', '迪庆藏族自治州', '530000', 'dq', '0', '1');
INSERT INTO `city` VALUES ('540100', '拉萨市', '540000', 'ls', '0', '1');
INSERT INTO `city` VALUES ('542100', '昌都地区', '540000', 'cd', '0', '1');
INSERT INTO `city` VALUES ('542200', '山南地区', '540000', 'sn', '0', '1');
INSERT INTO `city` VALUES ('542300', '日喀则地区', '540000', 'rg', '0', '1');
INSERT INTO `city` VALUES ('542400', '那曲地区', '540000', 'nq', '0', '1');
INSERT INTO `city` VALUES ('542500', '阿里地区', '540000', 'al', '0', '1');
INSERT INTO `city` VALUES ('542600', '林芝地区', '540000', 'lz', '0', '1');
INSERT INTO `city` VALUES ('610100', '西安市', '610000', 'xa', '0', '1');
INSERT INTO `city` VALUES ('610200', '铜川市', '610000', 'tc', '0', '1');
INSERT INTO `city` VALUES ('610300', '宝鸡市', '610000', 'bj', '0', '1');
INSERT INTO `city` VALUES ('610400', '咸阳市', '610000', 'xy', '0', '1');
INSERT INTO `city` VALUES ('610500', '渭南市', '610000', 'wn', '0', '1');
INSERT INTO `city` VALUES ('610600', '延安市', '610000', 'ya', '0', '1');
INSERT INTO `city` VALUES ('610700', '汉中市', '610000', 'hz', '0', '1');
INSERT INTO `city` VALUES ('610800', '榆林市', '610000', 'yl', '0', '1');
INSERT INTO `city` VALUES ('610900', '安康市', '610000', 'ak', '0', '1');
INSERT INTO `city` VALUES ('611000', '商洛市', '610000', 'sl', '0', '1');
INSERT INTO `city` VALUES ('620100', '兰州市', '620000', 'lz', '0', '1');
INSERT INTO `city` VALUES ('620200', '嘉峪关市', '620000', 'jy', '0', '1');
INSERT INTO `city` VALUES ('620300', '金昌市', '620000', 'jc', '0', '1');
INSERT INTO `city` VALUES ('620400', '白银市', '620000', 'by', '0', '1');
INSERT INTO `city` VALUES ('620500', '天水市', '620000', 'ts', '0', '1');
INSERT INTO `city` VALUES ('620600', '武威市', '620000', 'ww', '0', '1');
INSERT INTO `city` VALUES ('620700', '张掖市', '620000', 'zy', '0', '1');
INSERT INTO `city` VALUES ('620800', '平凉市', '620000', 'pl', '0', '1');
INSERT INTO `city` VALUES ('620900', '酒泉市', '620000', 'jq', '0', '1');
INSERT INTO `city` VALUES ('621000', '庆阳市', '620000', 'qy', '0', '1');
INSERT INTO `city` VALUES ('621100', '定西市', '620000', 'dx', '0', '1');
INSERT INTO `city` VALUES ('621200', '陇南市', '620000', 'ln', '0', '1');
INSERT INTO `city` VALUES ('622900', '临夏回族自治州', '620000', 'lx', '0', '1');
INSERT INTO `city` VALUES ('623000', '甘南藏族自治州', '620000', 'gn', '0', '1');
INSERT INTO `city` VALUES ('630100', '西宁市', '630000', 'xn', '0', '1');
INSERT INTO `city` VALUES ('632100', '海东地区', '630000', 'hd', '0', '1');
INSERT INTO `city` VALUES ('632200', '海北藏族自治州', '630000', 'hb', '0', '1');
INSERT INTO `city` VALUES ('632300', '黄南藏族自治州', '630000', 'hn', '0', '1');
INSERT INTO `city` VALUES ('632500', '海南藏族自治州', '630000', 'hn', '0', '1');
INSERT INTO `city` VALUES ('632600', '果洛藏族自治州', '630000', 'gl', '0', '1');
INSERT INTO `city` VALUES ('632700', '玉树藏族自治州', '630000', 'ys', '0', '1');
INSERT INTO `city` VALUES ('632800', '海西蒙古族藏族自治州', '630000', 'hx', '0', '1');
INSERT INTO `city` VALUES ('640100', '银川市', '640000', 'yc', '0', '1');
INSERT INTO `city` VALUES ('640200', '石嘴山市', '640000', 'sz', '0', '1');
INSERT INTO `city` VALUES ('640300', '吴忠市', '640000', 'wz', '0', '1');
INSERT INTO `city` VALUES ('640400', '固原市', '640000', 'gy', '0', '1');
INSERT INTO `city` VALUES ('640500', '中卫市', '640000', 'zw', '0', '1');
INSERT INTO `city` VALUES ('650100', '乌鲁木齐市', '650000', 'wl', '0', '1');
INSERT INTO `city` VALUES ('650200', '克拉玛依市', '650000', 'kl', '0', '1');
INSERT INTO `city` VALUES ('652100', '吐鲁番地区', '650000', 'tl', '0', '1');
INSERT INTO `city` VALUES ('652200', '哈密地区', '650000', 'hm', '0', '1');
INSERT INTO `city` VALUES ('652300', '昌吉回族自治州', '650000', 'lc', '0', '1');
INSERT INTO `city` VALUES ('652700', '博尔塔拉蒙古自治州', '650000', 'be', '0', '1');
INSERT INTO `city` VALUES ('652800', '巴音郭楞蒙古自治州', '650000', 'by', '0', '1');
INSERT INTO `city` VALUES ('652900', '阿克苏地区', '650000', 'ak', '0', '1');
INSERT INTO `city` VALUES ('653000', '克孜勒苏柯尔克孜自治州', '650000', 'kz', '0', '1');
INSERT INTO `city` VALUES ('653100', '喀什地区', '650000', 'gs', '0', '1');
INSERT INTO `city` VALUES ('653200', '和田地区', '650000', 'ht', '0', '1');
INSERT INTO `city` VALUES ('654000', '伊犁哈萨克自治州', '650000', 'yl', '0', '1');
INSERT INTO `city` VALUES ('654200', '塔城地区', '650000', 'tc', '0', '1');
INSERT INTO `city` VALUES ('654300', '阿勒泰地区', '650000', 'al', '0', '1');
INSERT INTO `city` VALUES ('659000', '省直辖行政单位', '650000', 'sz', '0', '1');

-- ----------------------------
-- Table structure for `da_an`
-- ----------------------------
DROP TABLE IF EXISTS `da_an`;
CREATE TABLE `da_an` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `tiHao` int(11) NOT NULL,
  `jiChuXinXiId` int(11) NOT NULL,
  `daAn` varchar(255) NOT NULL,
  `liangBiaoId` int(11) NOT NULL,
  `ciShu` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of da_an
-- ----------------------------

-- ----------------------------
-- Table structure for `deng_lu`
-- ----------------------------
DROP TABLE IF EXISTS `deng_lu`;
CREATE TABLE `deng_lu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `dengLuHao` varchar(255) NOT NULL,
  `miMa` varchar(255) NOT NULL,
  `quanXian` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deng_lu
-- ----------------------------
INSERT INTO `deng_lu` VALUES ('1', '0', 'w-mis', 'df8f6adccda0e6fe9a1fe7f074315f76', '1');
INSERT INTO `deng_lu` VALUES ('2', '0', '18632505440', '511c8b1394608f3cdfc9a597fd397944', '2');

-- ----------------------------
-- Table structure for `ji_chu_xin_xi`
-- ----------------------------
DROP TABLE IF EXISTS `ji_chu_xin_xi`;
CREATE TABLE `ji_chu_xin_xi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `yongHuId` varchar(255) NOT NULL,
  `riQi` datetime NOT NULL,
  `menZhenHao` varchar(255) DEFAULT NULL,
  `bingAnHao` varchar(255) DEFAULT NULL,
  `zhuGuanYiShi` varchar(255) DEFAULT NULL,
  `suoShuKeShi` varchar(255) DEFAULT NULL,
  `zhuanKeYiSheng` varchar(255) DEFAULT NULL,
  `xingMing` varchar(255) DEFAULT NULL,
  `xingBie` int(11) DEFAULT NULL,
  `chuShengNian` int(11) DEFAULT NULL,
  `chuShengYue` int(11) DEFAULT NULL,
  `chuShengRi` int(11) DEFAULT NULL,
  `minZu` varchar(255) DEFAULT NULL,
  `hunYinZhuangKuang` varchar(255) DEFAULT NULL,
  `shenGao` int(11) DEFAULT NULL,
  `tiZhong` int(11) DEFAULT NULL,
  `chuShengDi` varchar(255) DEFAULT NULL,
  `zhiYe` varchar(255) DEFAULT NULL,
  `wenHuaChengDu` varchar(255) DEFAULT NULL,
  `paiHang1` int(11) DEFAULT NULL,
  `paiHang2` int(11) DEFAULT NULL,
  `jingJiZhuangKuang` int(11) DEFAULT NULL,
  `lianXiDiZhi` varchar(255) DEFAULT NULL,
  `lianXiDianHua` varchar(255) DEFAULT NULL,
  `jiuZhenYuanYin` varchar(255) DEFAULT NULL,
  `shuiMian` varchar(255) DEFAULT NULL,
  `shiYu` int(11) DEFAULT NULL,
  `chuXian1` varchar(255) DEFAULT NULL,
  `chuXian2` varchar(255) DEFAULT NULL,
  `jiWangLeiSiFaZuo` int(11) DEFAULT NULL,
  `jiWangQuTiJiBing` int(11) DEFAULT NULL,
  `jiWangJuTiJiBingZhenDuan` text,
  `xianLeiSiFaZuo` int(11) DEFAULT NULL,
  `xianQuTiJiBing` int(11) DEFAULT NULL,
  `xianJuTiJiBingZhenDuan` text,
  `jiaZuBingShi` int(11) DEFAULT NULL,
  `jiaZuJuTiJiBingZhenDuan` text,
  `geXingTeDian` int(11) DEFAULT NULL,
  `QingXuWenDingXing` int(11) DEFAULT NULL,
  `RenGeTeDian` int(11) DEFAULT NULL,
  `XueXing` int(11) DEFAULT NULL,
  `RenGeTeZhi` varchar(255) DEFAULT NULL,
  `XingQu` varchar(255) DEFAULT NULL,
  `yan` int(11) DEFAULT NULL,
  `jiu` int(11) DEFAULT NULL,
  `yanJiuQiTa` varchar(255) DEFAULT NULL,
  `shengZhangFaYu` varchar(255) DEFAULT NULL,
  `xueBu` int(11) DEFAULT NULL,
  `yuYan` int(11) DEFAULT NULL,
  `yueJingChuChao` int(11) DEFAULT NULL,
  `shouCiYiJing` int(11) DEFAULT NULL,
  `tingJing` int(11) DEFAULT NULL,
  `youNianFuYangRen` varchar(255) DEFAULT NULL,
  `jiYangShi1` int(11) DEFAULT NULL,
  `jiYangShi2` int(11) DEFAULT NULL,
  `youNianShengHuoHuanJing` varchar(255) DEFAULT NULL,
  `xianZaiShengHuoHuanJIng` varchar(255) DEFAULT NULL,
  `xiongDiJieMeiGuanXi` int(11) DEFAULT NULL,
  `fuQiGuanXi` int(11) DEFAULT NULL,
  `poXiGuanXi` int(11) DEFAULT NULL,
  `fuQinZhiYe` varchar(255) DEFAULT NULL,
  `muQinZhiYe` varchar(255) DEFAULT NULL,
  `fuQinWenHuaChengDu` varchar(255) DEFAULT NULL,
  `muQinWenHuaChengDu` varchar(255) DEFAULT NULL,
  `zhongDaFuXingShiJian1` int(11) DEFAULT NULL,
  `zhongDaFuXingShiJian2` text,
  `yingJiShiJian1` int(11) DEFAULT NULL,
  `yingJiShiJian2` text,
  `renJiGuanXi` int(11) DEFAULT NULL,
  `wenTiBiaoXianWei` varchar(255) DEFAULT NULL,
  `wenTiFaShengZai` varchar(255) DEFAULT NULL,
  `shengHuoManYiYuFou` int(11) DEFAULT NULL,
  `buManYiDeFangMian` varchar(255) DEFAULT NULL,
  `dangQianJiBingRenZhi` int(11) DEFAULT NULL,
  `jiBingYuHouTaiDu` int(11) DEFAULT NULL,
  `yingDuiFangShi` int(11) DEFAULT NULL,
  `zhiLiaoCanYuChengDu` int(11) DEFAULT NULL,
  `sheHuiZhiChi` int(11) DEFAULT NULL,
  `pengYou` int(11) DEFAULT NULL,
  `jiaRen` int(11) DEFAULT NULL,
  `duiGeXiangZhiChiLiYongDu` int(11) DEFAULT NULL,
  `xingShengHuo` int(11) DEFAULT NULL,
  `wenTiFaShengQiTa` varchar(255) DEFAULT NULL,
  `yinXiang` int(11) DEFAULT NULL,
  `yinXiangQiTa` varchar(255) DEFAULT NULL,
  `chuZhi` int(11) DEFAULT NULL,
  `jiaPuTu` varchar(255) DEFAULT NULL,
  `fangShuRen` varchar(255) DEFAULT NULL,
  `miMa` varchar(255) DEFAULT '202cb962ac59075b964b07152d234b70',
  `keShiId` int(11) DEFAULT NULL,
  `zhuanKeYiShengId` int(11) DEFAULT NULL,
  `jingShenKeYiShengId` int(11) DEFAULT NULL,
  `yiYuanId` int(11) DEFAULT NULL,
  `cePingShi` varchar(255) DEFAULT NULL,
  `cePingShiId` int(11) DEFAULT NULL,
  `isGuiDang` tinyint(1) DEFAULT '0',
  `gdRiQi` datetime DEFAULT NULL,
  `jiaPuTuBeiZhu` text,
  `qinZiGuanXi` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ji_chu_xin_xi
-- ----------------------------

-- ----------------------------
-- Table structure for `jian_ce_xiang_mu`
-- ----------------------------
DROP TABLE IF EXISTS `jian_ce_xiang_mu`;
CREATE TABLE `jian_ce_xiang_mu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) DEFAULT '1',
  `jiChuXinXiId` int(11) NOT NULL,
  `riQi` datetime DEFAULT NULL,
  `naoDian` tinyint(1) NOT NULL DEFAULT '0',
  `ccbt` tinyint(1) NOT NULL DEFAULT '0',
  `naoRenZhi` tinyint(1) NOT NULL DEFAULT '0',
  `xinLiCePing` tinyint(1) NOT NULL DEFAULT '0',
  `yingYan` tinyint(1) NOT NULL DEFAULT '0',
  `hrv` tinyint(1) NOT NULL DEFAULT '0',
  `yongHuId` varchar(255) DEFAULT NULL,
  `xingMing` varchar(255) DEFAULT NULL,
  `xingBie` int(11) DEFAULT NULL,
  `chuShengNian` int(11) DEFAULT NULL,
  `chuShengYue` int(11) DEFAULT NULL,
  `chuShengRi` int(11) DEFAULT NULL,
  `jingShenKeYiSheng` varchar(255) DEFAULT NULL,
  `cePingShi` varchar(255) DEFAULT NULL,
  `shouZhenRiQi` datetime DEFAULT NULL,
  `yiYuanId` int(11) DEFAULT NULL,
  `isGuiDang` tinyint(1) DEFAULT '0',
  `gdRiQi` datetime DEFAULT NULL,
  `keShi` varchar(255) DEFAULT NULL,
  `zhuanKeYiSheng` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jian_ce_xiang_mu
-- ----------------------------

-- ----------------------------
-- Table structure for `ke_shi`
-- ----------------------------
DROP TABLE IF EXISTS `ke_shi`;
CREATE TABLE `ke_shi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `mingCheng` varchar(255) NOT NULL,
  `yiYuan` varchar(255) NOT NULL,
  `yiYuanId` int(11) NOT NULL,
  `isUse` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ke_shi
-- ----------------------------
INSERT INTO `ke_shi` VALUES ('1', '0', '心理咨询门诊', '唐山工人医院', '1', '1');

-- ----------------------------
-- Table structure for `liang_biao`
-- ----------------------------
DROP TABLE IF EXISTS `liang_biao`;
CREATE TABLE `liang_biao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) DEFAULT '0',
  `mingCheng` varchar(255) DEFAULT NULL,
  `jianJie` text,
  `yaoQiu` text,
  `shiJian` varchar(255) DEFAULT NULL,
  `zhuYiShiXiang` text,
  `yingYongPingJia` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of liang_biao
-- ----------------------------
INSERT INTO `liang_biao` VALUES ('1', '0', '体质分析量表', '体质是一种客观存在的生命现象，是个体生命过程中，在先天遗传和后天获得的基础上，表现出的形态结构、生理机能以及心理状态等方面综合的、相对稳定的特质。这种特质决定着人体对某种致病因子的易感性及其病变类型的倾向性。根据王琦教授的“中医体质九分法”，将人体体质概括为九种基本类型：平和质、气虚质、阳虚质、阴虚质、痰湿质、湿热质、淤血质、气郁质、特禀质。其中，除平和质外的其余八种体质均属于偏颇质，属于病理体质。本测试用于评定个体的体质类型。', '本测试包含60个问题，请仔细阅读每道题目，并根据最近一年的体验和感觉，选择最符合您情况的选项。答案无好坏对错之分，请务必如实作答。否则测评结果将不能反映您的真实情况，据此给出的养生建议对您也无效用。', '30分钟', null, null);
INSERT INTO `liang_biao` VALUES ('2', '0', '汉密顿焦虑量表', '汉密顿焦虑量表（Hamilton Anxiey Scale，HAMA）由Hamilton于1959年编制。它是精神科临床中常用的量表之一。本量表包括14个项目。由量表协作组（蔺国宪、朱昌明等）于1986年进行分析评定修订中国常模。是由医生对病人进行评价，也是国内使用十分广泛的量表。\r\n    HAMA所有项目采用五级评分法。各级的标准为：为无症状；轻；中等；重；极重。', null, '约20分钟', '1、主要用于评定神经症及其他病人的焦虑症状的严重程度。\r\n2、评定时间范围：入组时，评定当时或入组前一周的情况，治疗后2～6周，以同样方式，对入组患者再次评定，比较治疗前后的症状和病情的变化。\r\n3、汉密顿焦虑量表中除14项需要结合观察外，所有项目都根据病人的口头叙述进行评分，同时特别强调受检者的主观体验。', null);
INSERT INTO `liang_biao` VALUES ('3', '0', '汉密顿抑郁量表', '汉密顿抑郁量表（Hamilton Depression Scale，HAMD）由Hamilton于昕编制，是临床上评定抑郁状态时应用得最为普遍的量表。本量表有17项，21项和24项等3种版本，本测试采用的是24项版本。\r\n HAMD大部分项目采用五级评分法。各级的标准为：无；轻度；中度；重度；极重度； 少数项目采用三级评分法，其分级的标准为：无；轻～中度；重度。测试时每级都有具体的描述。\r\n    HAMD以总粗分和因子分两种方式计分，HAMD可归纳为7类因子结构：（1）焦虑/躯体化；（2）体重；（3）认识障碍；（4）日夜变化；（5）阻滞；（6）睡眠障碍；（7）绝望感。因子分可以更为简捷清晰地反映病人的实际特点。', null, '约20分钟', null, null);
INSERT INTO `liang_biao` VALUES ('4', '0', 'WCPA躯体症状分类量表', null, '下面表格中列出了有些可能有的症状，请仔细阅读每一条，然后根据您最近2周内的下列问题影响您或使您感到苦恼的程度，（最近两周的症状）', null, '', null);
INSERT INTO `liang_biao` VALUES ('5', '0', '90项症状清单', '又名症状自评量表（Self-reporting Inventory），有时也叫做Hopkin\'s症状清单（HSCL）。现版本由Derogatis编制于1973年。HSCL的最早版本编于1954年，称为“不适感量表”（Discomfort Scale）；至1965年，发展为64项的HSCL；70年代初，Derogatis编制了58项版本，HSCL-58，这是在SCL-90问世前应用和研究得最广泛的版本，至尽仍有人应用。以后发现，HSCL-58中恐怖性焦虑、愤怒-敌对的症状羡慕不足，而且缺乏反映更严重的精神病理症状-偏执观念和精神病性的项目，因此诞生了SCL-90。今年，Derogatis又编制了一个51项的文本，称为“简易症状问卷”（Brief Symptom Inventory、BSI）。但后者的应用时间尚短，还难作出确切的评价。\r\nSCL—90在国外应用甚广，80年代引入我国，随即广泛应用，是一种较受欢迎的自评量表。该量表的中译文本参考王征宇（1984）译稿。\r\n本量表共90个项目，包含有较广泛的精神症状学内容，从感觉、情感、思维、意识、行为直至生活习惯、人际关系、饮食睡眠等，均有涉及。　此量表使用简便，测查角度全面。它对有可能处于心理障碍边缘的人有良好的区分能力，适用于测查人群中哪些人可能有心理障碍、有何种心理障碍及其严重程度如何。在临床上常常作为诊断参考，也可以用作初级的筛查工具。', '以下列出了有些人可能会有的问题，请仔细地阅读每一条，然\r\n后根据最近一星期以内下述情况影响您的实际感觉，在每个问题后标明该题\r\n的程度得分。其中，“没有”选1，“很轻”选2，“中等”选3， “偏重”\r\n选4，“严重”选5。', '约15-30分钟', null, null);
INSERT INTO `liang_biao` VALUES ('6', '0', '艾森克个性测验', '艾森克人格理论（Eysenck\'s personality theory）英国心理学家H．J．艾森克提出的以人格结构层级说和三维度人格类型说为主要内容的人格理论。他认为，人格是由行为和行为群有机组织而成的层级结构。最低层是无数个具体反应，是可直接观察的具体行为。较高层是习惯性反应，它是具体反应经重复被固定下来的行为倾向。再高一层是特质，是一组习惯性反应的有机组合，如焦虑、固执等。最高一层是类型，是由一组相关特质的有机组合而成，具有高度概括的特征，对人的行为具有广泛的影响。他通过对人格问卷资料的因素分析研究，确定了人格类型的三个基本维度。根据外倾性维度可以把人格分为外倾型和内倾型；根据情绪稳定性可以把人格分为情绪型和稳定型；根据心理变态倾向可以把人格分为精神失调型和精神整合性。\r\n    艾森克个性调查表（Eysenck Personality Inventory，简称EPI）由英国心理学家H．J．艾森克所编。由莫兹利（Maudstey）医学问卷（1952）和莫兹利个性问卷（MPI，1959）发展而来（1975）。EPI是根据编者的多维人格学说而成，每一维度由一个分量表来测量，分N（Neuroticism，神经质）量表，测量情绪稳定与否；E（Extrovision-Introvision，外向-内向）；L（Lie，虚假、掩饰）系效度量表。\r\n    艾森克个性问卷（Eysenck Personality Questionaire，简称EPQ）系在EPI基础上加另一个分量表即P（Psychoticism，精神质）而成。分儿童（7—15岁）及成人（16岁以上）两式，有男女的年龄常模。在我国已有EPQ的修订本，仍分儿童和成人两式，各式的项目由原版分别为97和107项筛选成88及88项。结果分析方法上发展了T分表和各维度的分级方法。', '以下一些问题要求你按自己的实际情况回答，不要去猜测怎样才是正确的回答，因为这里不存在正确或错误的问题，也没有捉弄人的问题，将问题的意思看懂了就快点回答，不要花很多时间去想。', '约20-30分钟', null, null);
INSERT INTO `liang_biao` VALUES ('7', '0', '简明精神病量表', '简明精神病（科）量表（The Brief Psychiatric Rating Scale，BPRS）由Overall和Gorham于1962年编制。该量表是精神科应用得最广泛的评定量表之一，有18项。由量表协作研究组张明园（中华医学会精神卫生学会主任委员）、颜文伟进行分析评定修订中国常模。\r\n    该量表是精神科应用得最广泛的评定量表之一，有18项，采用1～7分的7级评分。各级的标准为：无症状；可疑或很轻；轻度；中度；偏重；重度；极重', null, '约20—30分钟', '时间范围：入组时，评定入组前一周的情况，以后一般相隔2～6周评定一次。\r\n本量表无具体的评分指导，主要根据症状定义及临床经验评分。', null);
INSERT INTO `liang_biao` VALUES ('8', '0', '躁狂量表', '贝克——拉范森躁狂量表（Bech-Rafaelsdn Mania Rating Scale BRMS）由Bech和Rafaelsen于1978年编制。本量表经国内量表协作组（崔庶等人）于1985试用并在国内推广，适用于躁郁症的躁狂相或情感性精神病的躁狂状态成人患者。\r\n本量表共11项。采用五级评分法，无该项症状或与患者正常时的水平相仿；症状轻微；中度症状；症状明显；症状严重。分别对13个项目进行评价。', null, '约20分钟', null, null);
INSERT INTO `liang_biao` VALUES ('9', '0', '痴呆简易筛查量表', '痴呆简易筛查量表（Brief Screening Scale for Dementia，BSSD），由量表协作研究组张明园（中华医学会精神卫生学会主任委员）于1987年编制的。本量表易于掌握，操作简便，可接受性高，是一个有效的，适合我国国情的痴呆筛查量表。\r\n本量表是应用较为广泛的痴呆量表，包括30个项目，其中常识/图征理解4项，短时记忆3项，语言理解3项，计算/注意3项，地点定向5项，时间定向4项，即刻记忆3项，物体命名3项及一些认知功能等。', null, '约35—40分钟', '1）年份/日期：可按照阳历或阴历纪年回答均为正确。\r\n2）五分分币，钢笔套，钥匙圈：回忆时，无须按照顺序。\r\n3）连续减数：上一个计算错误得0分，而下一个计算正确，后者可得1分。\r\n4）命令理解：要按指导语，将三个命令说完后，请被试者执行。', '1988年经由包括110例痴呆在内的1130名75岁以上的老人现场测试，结果表明，与其他类似工具相比，BSSD项目难度分布合理，项目间内部一致性好。联合检查法（ICC=0.96，RS=0.99）和重测法（RS=0.97）说明其具有良好的效度。按照该量表的分界值，BSSD敏感性为90%，特异性为85.1%，其效度是可以接受的。');
INSERT INTO `liang_biao` VALUES ('10', '0', '长谷川痴呆量表', '1974年，日本学者长谷川和夫创制了老年痴呆检查量表（Hastgawa Dementia Scale），至今已和简易精神状况速检表（MMSE）等共同成为当今世界上使用最为广泛的老年痴呆初筛工具之一，它的主要用途是用于群体的老年人调查。基于HDS是在日本民族社会文化背景基础上编制的，故在一定程度上更适合于我国等东方民族的老年人群使用。国内北京的张氏、上海的蔡氏等相继发展了他们的应用结果报告。\r\nHDS总计11项问题，其中包括定向力（2题）、记忆功能（4题）、常识（2题）、计算（1题）、物体铭记命名回忆（2题），在长谷川痴呆量表的基础上，根据我国的实际情况，对以下几项问题作了修改；将询问侵华战争结束日期或关东大地震日期改为中华人民共和国成立日期；将日本国总理大臣改问我国现任总理。', null, null, '1.记分采用正向记分法，满分为32.5分。\r\n2.第一项问题如被试者回答日期错误，而替代题“星期几”回答正确时，记为正确；第七项问题类推。\r\n3.第三项询问被试者年龄时，如回答相差3年以内者记为正确；第六项问题类推。\r\n4.第九题的减法运算，如两道题正确得4分，如答正确其中之一者得2分，两道题均错者得0分。第十题的倒背数测验记分方法类推，倒背数按每秒一个数字均速读出。\r\n5.第十一题的物体命名回忆：如铭记回忆全部错误或仅正确一项记为0分，正确两项记为0.5分，正确三项记为1.5分，正确四项记为2.5分，全部正确记为3.5分。', null);
INSERT INTO `liang_biao` VALUES ('11', '0', '阴性症状量表', '1982年，美国N.Andreason因研究阴性和阳性症状为主的精神分裂症的需要，编制了阴性症状量表（SANS）和阳性症状量表（SAPS）。由量表协作研究组（费立鹏、夏梅兰等）于1990年修订中国常模。\r\n    本量表以研究阴性和阳性症状为主的精神分裂症，它弥补了一些精神病评定量表对阴性症状注意不足的缺点。本量表分5个分量表，分别是：一、情感平淡或迟钝；二、思维贫乏；三、意志缺乏；四、兴趣社交缺乏；五、注意障碍。量表共有24个项目，做6级评分。其中情感平淡或迟钝的表现是：特征性表情，感受和反应的贫乏，可以是常规精神检查时观察病人的行为和应答的情况后进行评估，本项评分可能受到药物的影响。意志缺乏的特征是缺少精力和兴趣。病人不能主动发起或坚持完成各项任务。', null, '约20－30分钟', '1）评定时间范围为最近1月，用于药理学研究可缩短为1周。一般采用自然的临床精神检查方式进行交谈。\r\n2）慢性精神分裂症病人由于病情和缺乏自知力等原因，使量表中某些项目评定发生困难，往往需要借助别人报告或其他资料提供信息。\r\n3）SANS各分量表代表各阴性症状群，其分量表的最后一项是因子分评定，必须全面评估积压症状的严重性，有时，即使某一症状群中其余症状并不存在，单单一个症状（如高度言语内容贫乏），足以使言语障碍总评获得高分。', '量表作者和其他研究者均证明SANS的信度和效度良好。费立鹏等发现10名评定员检查15名病人共134次联合检查ICC高达0.94。对60例病人的重测ICC也达到0.80。864例次评定与BPRS的活力缺乏因子的相关系数为0.64。');
INSERT INTO `liang_biao` VALUES ('12', '0', '阳性症状量表', '阳性症状量表是对阴性症状量表进行补充，用于评定精神分裂症的阳性症状，包括幻觉、妄想、怪异行为和阳性思维形式障碍。　阳性症状量表（Scale for Assessment of Positive Symptoms，SAPS）由美国N. Andreason（1982）编制。该量表具有良好的信度效度，主要用途有二：一是用以区分精神分裂症的阳性/阴性症状为主的分型类别；二是用以评估阳性症状的严重程度及其变化。\r\n该量表的评定注意事项和统计分析指标及分型，和阴性症状量表相仿。SAPS有4个分量表，分别是：一、幻觉；二、妄想；三、怪异行为；四、阳性思维形式障碍。共有34个项目。评分为6级评分，在每个项目下有具体的评分标准，由经过训练的评定员对病人进行交谈检查。本量表用于评定最近一个月内的情况。如果用于药理学研究，可每周评定一次。', null, '约45-60分钟', null, 'SAPS的信度和效度良好。根据费立鹏等的资料，联合检查ICC为0.94，重测法ICC为0.80。与BPRS总分的相关系数为0.73。');
INSERT INTO `liang_biao` VALUES ('13', '0', '强迫量表', '本评定量表设计用来评定强迫性障碍（OCD）患者的症状严重程度和类型。一边而言，本量表的条目取决于患者的描述；不过，其最终评分仍基于晤谈者的临床评判。要求评定从晤谈钱一周开始直至并包括晤谈当时全过程中每一条目特征，评分反应整个星期每一条目的平均（均数）出现情况。 \r\n    本评定量表意在用作半定式晤谈。晤谈者应按照量表所列顺序评定各条目并用量表所提供的问题询问，但晤谈者为了澄清细节的目的可以自由询问补充问题。在晤谈期间，无论何时若患者主动提供病情，晤谈者对该项病情都宜予以考虑。评定应主要以晤谈期间患者的叙述与所获得观察结果为基础。若你断定患者提供的情况基本上不准确，那么患者的可靠性就值得怀疑，应在晤谈结束时作出相应注释。', null, null, null, null);
INSERT INTO `liang_biao` VALUES ('14', '0', '抑郁症筛查量表', null, '在过去的两周里, 你生活中以下症状出現的频率有多少？把相应的数字总合加起来。', null, null, null);
INSERT INTO `liang_biao` VALUES ('15', '0', '广泛性焦虑量表', null, '过去两周内，患者是否遇到如下7个焦虑相关问题', null, null, null);

-- ----------------------------
-- Table structure for `province`
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `province_id` varchar(20) NOT NULL,
  `province_name` varchar(50) NOT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('110000', '北京市');
INSERT INTO `province` VALUES ('120000', '天津市');
INSERT INTO `province` VALUES ('130000', '河北省');
INSERT INTO `province` VALUES ('140000', '山西省');
INSERT INTO `province` VALUES ('150000', '内蒙古自治区');
INSERT INTO `province` VALUES ('210000', '辽宁省');
INSERT INTO `province` VALUES ('220000', '吉林省');
INSERT INTO `province` VALUES ('230000', '黑龙江省');
INSERT INTO `province` VALUES ('310000', '上海市');
INSERT INTO `province` VALUES ('320000', '江苏省');
INSERT INTO `province` VALUES ('330000', '浙江省');
INSERT INTO `province` VALUES ('340000', '安徽省');
INSERT INTO `province` VALUES ('350000', '福建省');
INSERT INTO `province` VALUES ('360000', '江西省');
INSERT INTO `province` VALUES ('370000', '山东省');
INSERT INTO `province` VALUES ('410000', '河南省');
INSERT INTO `province` VALUES ('420000', '湖北省');
INSERT INTO `province` VALUES ('430000', '湖南省');
INSERT INTO `province` VALUES ('440000', '广东省');
INSERT INTO `province` VALUES ('450000', '广西壮族自治区');
INSERT INTO `province` VALUES ('460000', '海南省');
INSERT INTO `province` VALUES ('500000', '重庆市');
INSERT INTO `province` VALUES ('510000', '四川省');
INSERT INTO `province` VALUES ('520000', '贵州省');
INSERT INTO `province` VALUES ('530000', '云南省');
INSERT INTO `province` VALUES ('540000', '西藏自治区');
INSERT INTO `province` VALUES ('610000', '陕西省');
INSERT INTO `province` VALUES ('620000', '甘肃省');
INSERT INTO `province` VALUES ('630000', '青海省');
INSERT INTO `province` VALUES ('640000', '宁夏回族自治区');
INSERT INTO `province` VALUES ('650000', '新疆维吾尔自治区');
INSERT INTO `province` VALUES ('710000', '台湾省');
INSERT INTO `province` VALUES ('810000', '香港特别行政区');
INSERT INTO `province` VALUES ('820000', '澳门特别行政区');

-- ----------------------------
-- Table structure for `region`
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `region_id` int(10) NOT NULL,
  `region_name` varchar(50) NOT NULL COMMENT '地区名称',
  `city_id` int(10) NOT NULL DEFAULT '0' COMMENT '父地区ID',
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES ('110101', '东城区', '110100');
INSERT INTO `region` VALUES ('110102', '西城区', '110100');
INSERT INTO `region` VALUES ('110103', '崇文区', '110100');
INSERT INTO `region` VALUES ('110104', '宣武区', '110100');
INSERT INTO `region` VALUES ('110105', '朝阳区', '110100');
INSERT INTO `region` VALUES ('110106', '丰台区', '110100');
INSERT INTO `region` VALUES ('110107', '石景山区', '110100');
INSERT INTO `region` VALUES ('110108', '海淀区', '110100');
INSERT INTO `region` VALUES ('110109', '门头沟区', '110100');
INSERT INTO `region` VALUES ('110111', '房山区', '110100');
INSERT INTO `region` VALUES ('110112', '通州区', '110100');
INSERT INTO `region` VALUES ('110113', '顺义区', '110100');
INSERT INTO `region` VALUES ('110114', '昌平区', '110100');
INSERT INTO `region` VALUES ('110115', '大兴区', '110100');
INSERT INTO `region` VALUES ('110116', '怀柔区', '110100');
INSERT INTO `region` VALUES ('110117', '平谷区', '110100');
INSERT INTO `region` VALUES ('110228', '密云县', '110200');
INSERT INTO `region` VALUES ('110229', '延庆县', '110200');
INSERT INTO `region` VALUES ('120101', '和平区', '120100');
INSERT INTO `region` VALUES ('120102', '河东区', '120100');
INSERT INTO `region` VALUES ('120103', '河西区', '120100');
INSERT INTO `region` VALUES ('120104', '南开区', '120100');
INSERT INTO `region` VALUES ('120105', '河北区', '120100');
INSERT INTO `region` VALUES ('120106', '红桥区', '120100');
INSERT INTO `region` VALUES ('120107', '塘沽区', '120100');
INSERT INTO `region` VALUES ('120108', '汉沽区', '120100');
INSERT INTO `region` VALUES ('120109', '大港区', '120100');
INSERT INTO `region` VALUES ('120110', '东丽区', '120100');
INSERT INTO `region` VALUES ('120111', '西青区', '120100');
INSERT INTO `region` VALUES ('120112', '津南区', '120100');
INSERT INTO `region` VALUES ('120113', '北辰区', '120100');
INSERT INTO `region` VALUES ('120114', '武清区', '120100');
INSERT INTO `region` VALUES ('120115', '宝坻区', '120100');
INSERT INTO `region` VALUES ('120221', '宁河县', '120200');
INSERT INTO `region` VALUES ('120223', '静海县', '120200');
INSERT INTO `region` VALUES ('120225', '蓟　县', '120200');
INSERT INTO `region` VALUES ('130101', '市辖区', '130100');
INSERT INTO `region` VALUES ('130102', '长安区', '130100');
INSERT INTO `region` VALUES ('130103', '桥东区', '130100');
INSERT INTO `region` VALUES ('130104', '桥西区', '130100');
INSERT INTO `region` VALUES ('130105', '新华区', '130100');
INSERT INTO `region` VALUES ('130107', '井陉矿区', '130100');
INSERT INTO `region` VALUES ('130108', '裕华区', '130100');
INSERT INTO `region` VALUES ('130121', '井陉县', '130100');
INSERT INTO `region` VALUES ('130123', '正定县', '130100');
INSERT INTO `region` VALUES ('130124', '栾城县', '130100');
INSERT INTO `region` VALUES ('130125', '行唐县', '130100');
INSERT INTO `region` VALUES ('130126', '灵寿县', '130100');
INSERT INTO `region` VALUES ('130127', '高邑县', '130100');
INSERT INTO `region` VALUES ('130128', '深泽县', '130100');
INSERT INTO `region` VALUES ('130129', '赞皇县', '130100');
INSERT INTO `region` VALUES ('130130', '无极县', '130100');
INSERT INTO `region` VALUES ('130131', '平山县', '130100');
INSERT INTO `region` VALUES ('130132', '元氏县', '130100');
INSERT INTO `region` VALUES ('130133', '赵　县', '130100');
INSERT INTO `region` VALUES ('130181', '辛集市', '130100');
INSERT INTO `region` VALUES ('130182', '藁城市', '130100');
INSERT INTO `region` VALUES ('130183', '晋州市', '130100');
INSERT INTO `region` VALUES ('130184', '新乐市', '130100');
INSERT INTO `region` VALUES ('130185', '鹿泉市', '130100');
INSERT INTO `region` VALUES ('130201', '市辖区', '130200');
INSERT INTO `region` VALUES ('130202', '路南区', '130200');
INSERT INTO `region` VALUES ('130203', '路北区', '130200');
INSERT INTO `region` VALUES ('130204', '古冶区', '130200');
INSERT INTO `region` VALUES ('130205', '开平区', '130200');
INSERT INTO `region` VALUES ('130207', '丰南区', '130200');
INSERT INTO `region` VALUES ('130208', '丰润区', '130200');
INSERT INTO `region` VALUES ('130223', '滦　县', '130200');
INSERT INTO `region` VALUES ('130224', '滦南县', '130200');
INSERT INTO `region` VALUES ('130225', '乐亭县', '130200');
INSERT INTO `region` VALUES ('130227', '迁西县', '130200');
INSERT INTO `region` VALUES ('130229', '玉田县', '130200');
INSERT INTO `region` VALUES ('130230', '唐海县', '130200');
INSERT INTO `region` VALUES ('130281', '遵化市', '130200');
INSERT INTO `region` VALUES ('130283', '迁安市', '130200');
INSERT INTO `region` VALUES ('130301', '市辖区', '130300');
INSERT INTO `region` VALUES ('130302', '海港区', '130300');
INSERT INTO `region` VALUES ('130303', '山海关区', '130300');
INSERT INTO `region` VALUES ('130304', '北戴河区', '130300');
INSERT INTO `region` VALUES ('130321', '青龙满族自治县', '130300');
INSERT INTO `region` VALUES ('130322', '昌黎县', '130300');
INSERT INTO `region` VALUES ('130323', '抚宁县', '130300');
INSERT INTO `region` VALUES ('130324', '卢龙县', '130300');
INSERT INTO `region` VALUES ('130401', '市辖区', '130400');
INSERT INTO `region` VALUES ('130402', '邯山区', '130400');
INSERT INTO `region` VALUES ('130403', '丛台区', '130400');
INSERT INTO `region` VALUES ('130404', '复兴区', '130400');
INSERT INTO `region` VALUES ('130406', '峰峰矿区', '130400');
INSERT INTO `region` VALUES ('130421', '邯郸县', '130400');
INSERT INTO `region` VALUES ('130423', '临漳县', '130400');
INSERT INTO `region` VALUES ('130424', '成安县', '130400');
INSERT INTO `region` VALUES ('130425', '大名县', '130400');
INSERT INTO `region` VALUES ('130426', '涉　县', '130400');
INSERT INTO `region` VALUES ('130427', '磁　县', '130400');
INSERT INTO `region` VALUES ('130428', '肥乡县', '130400');
INSERT INTO `region` VALUES ('130429', '永年县', '130400');
INSERT INTO `region` VALUES ('130430', '邱　县', '130400');
INSERT INTO `region` VALUES ('130431', '鸡泽县', '130400');
INSERT INTO `region` VALUES ('130432', '广平县', '130400');
INSERT INTO `region` VALUES ('130433', '馆陶县', '130400');
INSERT INTO `region` VALUES ('130434', '魏　县', '130400');
INSERT INTO `region` VALUES ('130435', '曲周县', '130400');
INSERT INTO `region` VALUES ('130481', '武安市', '130400');
INSERT INTO `region` VALUES ('130501', '市辖区', '130500');
INSERT INTO `region` VALUES ('130502', '桥东区', '130500');
INSERT INTO `region` VALUES ('130503', '桥西区', '130500');
INSERT INTO `region` VALUES ('130521', '邢台县', '130500');
INSERT INTO `region` VALUES ('130522', '临城县', '130500');
INSERT INTO `region` VALUES ('130523', '内丘县', '130500');
INSERT INTO `region` VALUES ('130524', '柏乡县', '130500');
INSERT INTO `region` VALUES ('130525', '隆尧县', '130500');
INSERT INTO `region` VALUES ('130526', '任　县', '130500');
INSERT INTO `region` VALUES ('130527', '南和县', '130500');
INSERT INTO `region` VALUES ('130528', '宁晋县', '130500');
INSERT INTO `region` VALUES ('130529', '巨鹿县', '130500');
INSERT INTO `region` VALUES ('130530', '新河县', '130500');
INSERT INTO `region` VALUES ('130531', '广宗县', '130500');
INSERT INTO `region` VALUES ('130532', '平乡县', '130500');
INSERT INTO `region` VALUES ('130533', '威　县', '130500');
INSERT INTO `region` VALUES ('130534', '清河县', '130500');
INSERT INTO `region` VALUES ('130535', '临西县', '130500');
INSERT INTO `region` VALUES ('130581', '南宫市', '130500');
INSERT INTO `region` VALUES ('130582', '沙河市', '130500');
INSERT INTO `region` VALUES ('130601', '市辖区', '130600');
INSERT INTO `region` VALUES ('130602', '新市区', '130600');
INSERT INTO `region` VALUES ('130603', '北市区', '130600');
INSERT INTO `region` VALUES ('130604', '南市区', '130600');
INSERT INTO `region` VALUES ('130621', '满城县', '130600');
INSERT INTO `region` VALUES ('130622', '清苑县', '130600');
INSERT INTO `region` VALUES ('130623', '涞水县', '130600');
INSERT INTO `region` VALUES ('130624', '阜平县', '130600');
INSERT INTO `region` VALUES ('130625', '徐水县', '130600');
INSERT INTO `region` VALUES ('130626', '定兴县', '130600');
INSERT INTO `region` VALUES ('130627', '唐　县', '130600');
INSERT INTO `region` VALUES ('130628', '高阳县', '130600');
INSERT INTO `region` VALUES ('130629', '容城县', '130600');
INSERT INTO `region` VALUES ('130630', '涞源县', '130600');
INSERT INTO `region` VALUES ('130631', '望都县', '130600');
INSERT INTO `region` VALUES ('130632', '安新县', '130600');
INSERT INTO `region` VALUES ('130633', '易　县', '130600');
INSERT INTO `region` VALUES ('130634', '曲阳县', '130600');
INSERT INTO `region` VALUES ('130635', '蠡　县', '130600');
INSERT INTO `region` VALUES ('130636', '顺平县', '130600');
INSERT INTO `region` VALUES ('130637', '博野县', '130600');
INSERT INTO `region` VALUES ('130638', '雄　县', '130600');
INSERT INTO `region` VALUES ('130681', '涿州市', '130600');
INSERT INTO `region` VALUES ('130682', '定州市', '130600');
INSERT INTO `region` VALUES ('130683', '安国市', '130600');
INSERT INTO `region` VALUES ('130684', '高碑店市', '130600');
INSERT INTO `region` VALUES ('130701', '市辖区', '130700');
INSERT INTO `region` VALUES ('130702', '桥东区', '130700');
INSERT INTO `region` VALUES ('130703', '桥西区', '130700');
INSERT INTO `region` VALUES ('130705', '宣化区', '130700');
INSERT INTO `region` VALUES ('130706', '下花园区', '130700');
INSERT INTO `region` VALUES ('130721', '宣化县', '130700');
INSERT INTO `region` VALUES ('130722', '张北县', '130700');
INSERT INTO `region` VALUES ('130723', '康保县', '130700');
INSERT INTO `region` VALUES ('130724', '沽源县', '130700');
INSERT INTO `region` VALUES ('130725', '尚义县', '130700');
INSERT INTO `region` VALUES ('130726', '蔚　县', '130700');
INSERT INTO `region` VALUES ('130727', '阳原县', '130700');
INSERT INTO `region` VALUES ('130728', '怀安县', '130700');
INSERT INTO `region` VALUES ('130729', '万全县', '130700');
INSERT INTO `region` VALUES ('130730', '怀来县', '130700');
INSERT INTO `region` VALUES ('130731', '涿鹿县', '130700');
INSERT INTO `region` VALUES ('130732', '赤城县', '130700');
INSERT INTO `region` VALUES ('130733', '崇礼县', '130700');
INSERT INTO `region` VALUES ('130801', '市辖区', '130800');
INSERT INTO `region` VALUES ('130802', '双桥区', '130800');
INSERT INTO `region` VALUES ('130803', '双滦区', '130800');
INSERT INTO `region` VALUES ('130804', '鹰手营子矿区', '130800');
INSERT INTO `region` VALUES ('130821', '承德县', '130800');
INSERT INTO `region` VALUES ('130822', '兴隆县', '130800');
INSERT INTO `region` VALUES ('130823', '平泉县', '130800');
INSERT INTO `region` VALUES ('130824', '滦平县', '130800');
INSERT INTO `region` VALUES ('130825', '隆化县', '130800');
INSERT INTO `region` VALUES ('130826', '丰宁满族自治县', '130800');
INSERT INTO `region` VALUES ('130827', '宽城满族自治县', '130800');
INSERT INTO `region` VALUES ('130828', '围场满族蒙古族自治县', '130800');
INSERT INTO `region` VALUES ('130901', '市辖区', '130900');
INSERT INTO `region` VALUES ('130902', '新华区', '130900');
INSERT INTO `region` VALUES ('130903', '运河区', '130900');
INSERT INTO `region` VALUES ('130921', '沧　县', '130900');
INSERT INTO `region` VALUES ('130922', '青　县', '130900');
INSERT INTO `region` VALUES ('130923', '东光县', '130900');
INSERT INTO `region` VALUES ('130924', '海兴县', '130900');
INSERT INTO `region` VALUES ('130925', '盐山县', '130900');
INSERT INTO `region` VALUES ('130926', '肃宁县', '130900');
INSERT INTO `region` VALUES ('130927', '南皮县', '130900');
INSERT INTO `region` VALUES ('130928', '吴桥县', '130900');
INSERT INTO `region` VALUES ('130929', '献　县', '130900');
INSERT INTO `region` VALUES ('130930', '孟村回族自治县', '130900');
INSERT INTO `region` VALUES ('130981', '泊头市', '130900');
INSERT INTO `region` VALUES ('130982', '任丘市', '130900');
INSERT INTO `region` VALUES ('130983', '黄骅市', '130900');
INSERT INTO `region` VALUES ('130984', '河间市', '130900');
INSERT INTO `region` VALUES ('131001', '市辖区', '131000');
INSERT INTO `region` VALUES ('131002', '安次区', '131000');
INSERT INTO `region` VALUES ('131003', '广阳区', '131000');
INSERT INTO `region` VALUES ('131022', '固安县', '131000');
INSERT INTO `region` VALUES ('131023', '永清县', '131000');
INSERT INTO `region` VALUES ('131024', '香河县', '131000');
INSERT INTO `region` VALUES ('131025', '大城县', '131000');
INSERT INTO `region` VALUES ('131026', '文安县', '131000');
INSERT INTO `region` VALUES ('131028', '大厂回族自治县', '131000');
INSERT INTO `region` VALUES ('131081', '霸州市', '131000');
INSERT INTO `region` VALUES ('131082', '三河市', '131000');
INSERT INTO `region` VALUES ('131101', '市辖区', '131100');
INSERT INTO `region` VALUES ('131102', '桃城区', '131100');
INSERT INTO `region` VALUES ('131121', '枣强县', '131100');
INSERT INTO `region` VALUES ('131122', '武邑县', '131100');
INSERT INTO `region` VALUES ('131123', '武强县', '131100');
INSERT INTO `region` VALUES ('131124', '饶阳县', '131100');
INSERT INTO `region` VALUES ('131125', '安平县', '131100');
INSERT INTO `region` VALUES ('131126', '故城县', '131100');
INSERT INTO `region` VALUES ('131127', '景　县', '131100');
INSERT INTO `region` VALUES ('131128', '阜城县', '131100');
INSERT INTO `region` VALUES ('131181', '冀州市', '131100');
INSERT INTO `region` VALUES ('131182', '深州市', '131100');
INSERT INTO `region` VALUES ('140101', '市辖区', '140100');
INSERT INTO `region` VALUES ('140105', '小店区', '140100');
INSERT INTO `region` VALUES ('140106', '迎泽区', '140100');
INSERT INTO `region` VALUES ('140107', '杏花岭区', '140100');
INSERT INTO `region` VALUES ('140108', '尖草坪区', '140100');
INSERT INTO `region` VALUES ('140109', '万柏林区', '140100');
INSERT INTO `region` VALUES ('140110', '晋源区', '140100');
INSERT INTO `region` VALUES ('140121', '清徐县', '140100');
INSERT INTO `region` VALUES ('140122', '阳曲县', '140100');
INSERT INTO `region` VALUES ('140123', '娄烦县', '140100');
INSERT INTO `region` VALUES ('140181', '古交市', '140100');
INSERT INTO `region` VALUES ('140201', '市辖区', '140200');
INSERT INTO `region` VALUES ('140202', '城　区', '140200');
INSERT INTO `region` VALUES ('140203', '矿　区', '140200');
INSERT INTO `region` VALUES ('140211', '南郊区', '140200');
INSERT INTO `region` VALUES ('140212', '新荣区', '140200');
INSERT INTO `region` VALUES ('140221', '阳高县', '140200');
INSERT INTO `region` VALUES ('140222', '天镇县', '140200');
INSERT INTO `region` VALUES ('140223', '广灵县', '140200');
INSERT INTO `region` VALUES ('140224', '灵丘县', '140200');
INSERT INTO `region` VALUES ('140225', '浑源县', '140200');
INSERT INTO `region` VALUES ('140226', '左云县', '140200');
INSERT INTO `region` VALUES ('140227', '大同县', '140200');
INSERT INTO `region` VALUES ('140301', '市辖区', '140300');
INSERT INTO `region` VALUES ('140302', '城　区', '140300');
INSERT INTO `region` VALUES ('140303', '矿　区', '140300');
INSERT INTO `region` VALUES ('140311', '郊　区', '140300');
INSERT INTO `region` VALUES ('140321', '平定县', '140300');
INSERT INTO `region` VALUES ('140322', '盂　县', '140300');
INSERT INTO `region` VALUES ('140401', '市辖区', '140400');
INSERT INTO `region` VALUES ('140402', '城　区', '140400');
INSERT INTO `region` VALUES ('140411', '郊　区', '140400');
INSERT INTO `region` VALUES ('140421', '长治县', '140400');
INSERT INTO `region` VALUES ('140423', '襄垣县', '140400');
INSERT INTO `region` VALUES ('140424', '屯留县', '140400');
INSERT INTO `region` VALUES ('140425', '平顺县', '140400');
INSERT INTO `region` VALUES ('140426', '黎城县', '140400');
INSERT INTO `region` VALUES ('140427', '壶关县', '140400');
INSERT INTO `region` VALUES ('140428', '长子县', '140400');
INSERT INTO `region` VALUES ('140429', '武乡县', '140400');
INSERT INTO `region` VALUES ('140430', '沁　县', '140400');
INSERT INTO `region` VALUES ('140431', '沁源县', '140400');
INSERT INTO `region` VALUES ('140481', '潞城市', '140400');
INSERT INTO `region` VALUES ('140501', '市辖区', '140500');
INSERT INTO `region` VALUES ('140502', '城　区', '140500');
INSERT INTO `region` VALUES ('140521', '沁水县', '140500');
INSERT INTO `region` VALUES ('140522', '阳城县', '140500');
INSERT INTO `region` VALUES ('140524', '陵川县', '140500');
INSERT INTO `region` VALUES ('140525', '泽州县', '140500');
INSERT INTO `region` VALUES ('140581', '高平市', '140500');
INSERT INTO `region` VALUES ('140601', '市辖区', '140600');
INSERT INTO `region` VALUES ('140602', '朔城区', '140600');
INSERT INTO `region` VALUES ('140603', '平鲁区', '140600');
INSERT INTO `region` VALUES ('140621', '山阴县', '140600');
INSERT INTO `region` VALUES ('140622', '应　县', '140600');
INSERT INTO `region` VALUES ('140623', '右玉县', '140600');
INSERT INTO `region` VALUES ('140624', '怀仁县', '140600');
INSERT INTO `region` VALUES ('140701', '市辖区', '140700');
INSERT INTO `region` VALUES ('140702', '榆次区', '140700');
INSERT INTO `region` VALUES ('140721', '榆社县', '140700');
INSERT INTO `region` VALUES ('140722', '左权县', '140700');
INSERT INTO `region` VALUES ('140723', '和顺县', '140700');
INSERT INTO `region` VALUES ('140724', '昔阳县', '140700');
INSERT INTO `region` VALUES ('140725', '寿阳县', '140700');
INSERT INTO `region` VALUES ('140726', '太谷县', '140700');
INSERT INTO `region` VALUES ('140727', '祁　县', '140700');
INSERT INTO `region` VALUES ('140728', '平遥县', '140700');
INSERT INTO `region` VALUES ('140729', '灵石县', '140700');
INSERT INTO `region` VALUES ('140781', '介休市', '140700');
INSERT INTO `region` VALUES ('140801', '市辖区', '140800');
INSERT INTO `region` VALUES ('140802', '盐湖区', '140800');
INSERT INTO `region` VALUES ('140821', '临猗县', '140800');
INSERT INTO `region` VALUES ('140822', '万荣县', '140800');
INSERT INTO `region` VALUES ('140823', '闻喜县', '140800');
INSERT INTO `region` VALUES ('140824', '稷山县', '140800');
INSERT INTO `region` VALUES ('140825', '新绛县', '140800');
INSERT INTO `region` VALUES ('140826', '绛　县', '140800');
INSERT INTO `region` VALUES ('140827', '垣曲县', '140800');
INSERT INTO `region` VALUES ('140828', '夏　县', '140800');
INSERT INTO `region` VALUES ('140829', '平陆县', '140800');
INSERT INTO `region` VALUES ('140830', '芮城县', '140800');
INSERT INTO `region` VALUES ('140881', '永济市', '140800');
INSERT INTO `region` VALUES ('140882', '河津市', '140800');
INSERT INTO `region` VALUES ('140901', '市辖区', '140900');
INSERT INTO `region` VALUES ('140902', '忻府区', '140900');
INSERT INTO `region` VALUES ('140921', '定襄县', '140900');
INSERT INTO `region` VALUES ('140922', '五台县', '140900');
INSERT INTO `region` VALUES ('140923', '代　县', '140900');
INSERT INTO `region` VALUES ('140924', '繁峙县', '140900');
INSERT INTO `region` VALUES ('140925', '宁武县', '140900');
INSERT INTO `region` VALUES ('140926', '静乐县', '140900');
INSERT INTO `region` VALUES ('140927', '神池县', '140900');
INSERT INTO `region` VALUES ('140928', '五寨县', '140900');
INSERT INTO `region` VALUES ('140929', '岢岚县', '140900');
INSERT INTO `region` VALUES ('140930', '河曲县', '140900');
INSERT INTO `region` VALUES ('140931', '保德县', '140900');
INSERT INTO `region` VALUES ('140932', '偏关县', '140900');
INSERT INTO `region` VALUES ('140981', '原平市', '140900');
INSERT INTO `region` VALUES ('141001', '市辖区', '141000');
INSERT INTO `region` VALUES ('141002', '尧都区', '141000');
INSERT INTO `region` VALUES ('141021', '曲沃县', '141000');
INSERT INTO `region` VALUES ('141022', '翼城县', '141000');
INSERT INTO `region` VALUES ('141023', '襄汾县', '141000');
INSERT INTO `region` VALUES ('141024', '洪洞县', '141000');
INSERT INTO `region` VALUES ('141025', '古　县', '141000');
INSERT INTO `region` VALUES ('141026', '安泽县', '141000');
INSERT INTO `region` VALUES ('141027', '浮山县', '141000');
INSERT INTO `region` VALUES ('141028', '吉　县', '141000');
INSERT INTO `region` VALUES ('141029', '乡宁县', '141000');
INSERT INTO `region` VALUES ('141030', '大宁县', '141000');
INSERT INTO `region` VALUES ('141031', '隰　县', '141000');
INSERT INTO `region` VALUES ('141032', '永和县', '141000');
INSERT INTO `region` VALUES ('141033', '蒲　县', '141000');
INSERT INTO `region` VALUES ('141034', '汾西县', '141000');
INSERT INTO `region` VALUES ('141081', '侯马市', '141000');
INSERT INTO `region` VALUES ('141082', '霍州市', '141000');
INSERT INTO `region` VALUES ('141101', '市辖区', '141100');
INSERT INTO `region` VALUES ('141102', '离石区', '141100');
INSERT INTO `region` VALUES ('141121', '文水县', '141100');
INSERT INTO `region` VALUES ('141122', '交城县', '141100');
INSERT INTO `region` VALUES ('141123', '兴　县', '141100');
INSERT INTO `region` VALUES ('141124', '临　县', '141100');
INSERT INTO `region` VALUES ('141125', '柳林县', '141100');
INSERT INTO `region` VALUES ('141126', '石楼县', '141100');
INSERT INTO `region` VALUES ('141127', '岚　县', '141100');
INSERT INTO `region` VALUES ('141128', '方山县', '141100');
INSERT INTO `region` VALUES ('141129', '中阳县', '141100');
INSERT INTO `region` VALUES ('141130', '交口县', '141100');
INSERT INTO `region` VALUES ('141181', '孝义市', '141100');
INSERT INTO `region` VALUES ('141182', '汾阳市', '141100');
INSERT INTO `region` VALUES ('150101', '市辖区', '150100');
INSERT INTO `region` VALUES ('150102', '新城区', '150100');
INSERT INTO `region` VALUES ('150103', '回民区', '150100');
INSERT INTO `region` VALUES ('150104', '玉泉区', '150100');
INSERT INTO `region` VALUES ('150105', '赛罕区', '150100');
INSERT INTO `region` VALUES ('150121', '土默特左旗', '150100');
INSERT INTO `region` VALUES ('150122', '托克托县', '150100');
INSERT INTO `region` VALUES ('150123', '和林格尔县', '150100');
INSERT INTO `region` VALUES ('150124', '清水河县', '150100');
INSERT INTO `region` VALUES ('150125', '武川县', '150100');
INSERT INTO `region` VALUES ('150201', '市辖区', '150200');
INSERT INTO `region` VALUES ('150202', '东河区', '150200');
INSERT INTO `region` VALUES ('150203', '昆都仑区', '150200');
INSERT INTO `region` VALUES ('150204', '青山区', '150200');
INSERT INTO `region` VALUES ('150205', '石拐区', '150200');
INSERT INTO `region` VALUES ('150206', '白云矿区', '150200');
INSERT INTO `region` VALUES ('150207', '九原区', '150200');
INSERT INTO `region` VALUES ('150221', '土默特右旗', '150200');
INSERT INTO `region` VALUES ('150222', '固阳县', '150200');
INSERT INTO `region` VALUES ('150223', '达尔罕茂明安联合旗', '150200');
INSERT INTO `region` VALUES ('150301', '市辖区', '150300');
INSERT INTO `region` VALUES ('150302', '海勃湾区', '150300');
INSERT INTO `region` VALUES ('150303', '海南区', '150300');
INSERT INTO `region` VALUES ('150304', '乌达区', '150300');
INSERT INTO `region` VALUES ('150401', '市辖区', '150400');
INSERT INTO `region` VALUES ('150402', '红山区', '150400');
INSERT INTO `region` VALUES ('150403', '元宝山区', '150400');
INSERT INTO `region` VALUES ('150404', '松山区', '150400');
INSERT INTO `region` VALUES ('150421', '阿鲁科尔沁旗', '150400');
INSERT INTO `region` VALUES ('150422', '巴林左旗', '150400');
INSERT INTO `region` VALUES ('150423', '巴林右旗', '150400');
INSERT INTO `region` VALUES ('150424', '林西县', '150400');
INSERT INTO `region` VALUES ('150425', '克什克腾旗', '150400');
INSERT INTO `region` VALUES ('150426', '翁牛特旗', '150400');
INSERT INTO `region` VALUES ('150428', '喀喇沁旗', '150400');
INSERT INTO `region` VALUES ('150429', '宁城县', '150400');
INSERT INTO `region` VALUES ('150430', '敖汉旗', '150400');
INSERT INTO `region` VALUES ('150501', '市辖区', '150500');
INSERT INTO `region` VALUES ('150502', '科尔沁区', '150500');
INSERT INTO `region` VALUES ('150521', '科尔沁左翼中旗', '150500');
INSERT INTO `region` VALUES ('150522', '科尔沁左翼后旗', '150500');
INSERT INTO `region` VALUES ('150523', '开鲁县', '150500');
INSERT INTO `region` VALUES ('150524', '库伦旗', '150500');
INSERT INTO `region` VALUES ('150525', '奈曼旗', '150500');
INSERT INTO `region` VALUES ('150526', '扎鲁特旗', '150500');
INSERT INTO `region` VALUES ('150581', '霍林郭勒市', '150500');
INSERT INTO `region` VALUES ('150602', '东胜区', '150600');
INSERT INTO `region` VALUES ('150621', '达拉特旗', '150600');
INSERT INTO `region` VALUES ('150622', '准格尔旗', '150600');
INSERT INTO `region` VALUES ('150623', '鄂托克前旗', '150600');
INSERT INTO `region` VALUES ('150624', '鄂托克旗', '150600');
INSERT INTO `region` VALUES ('150625', '杭锦旗', '150600');
INSERT INTO `region` VALUES ('150626', '乌审旗', '150600');
INSERT INTO `region` VALUES ('150627', '伊金霍洛旗', '150600');
INSERT INTO `region` VALUES ('150701', '市辖区', '150700');
INSERT INTO `region` VALUES ('150702', '海拉尔区', '150700');
INSERT INTO `region` VALUES ('150721', '阿荣旗', '150700');
INSERT INTO `region` VALUES ('150722', '莫力达瓦达斡尔族自治旗', '150700');
INSERT INTO `region` VALUES ('150723', '鄂伦春自治旗', '150700');
INSERT INTO `region` VALUES ('150724', '鄂温克族自治旗', '150700');
INSERT INTO `region` VALUES ('150725', '陈巴尔虎旗', '150700');
INSERT INTO `region` VALUES ('150726', '新巴尔虎左旗', '150700');
INSERT INTO `region` VALUES ('150727', '新巴尔虎右旗', '150700');
INSERT INTO `region` VALUES ('150781', '满洲里市', '150700');
INSERT INTO `region` VALUES ('150782', '牙克石市', '150700');
INSERT INTO `region` VALUES ('150783', '扎兰屯市', '150700');
INSERT INTO `region` VALUES ('150784', '额尔古纳市', '150700');
INSERT INTO `region` VALUES ('150785', '根河市', '150700');
INSERT INTO `region` VALUES ('150801', '市辖区', '150800');
INSERT INTO `region` VALUES ('150802', '临河区', '150800');
INSERT INTO `region` VALUES ('150821', '五原县', '150800');
INSERT INTO `region` VALUES ('150822', '磴口县', '150800');
INSERT INTO `region` VALUES ('150823', '乌拉特前旗', '150800');
INSERT INTO `region` VALUES ('150824', '乌拉特中旗', '150800');
INSERT INTO `region` VALUES ('150825', '乌拉特后旗', '150800');
INSERT INTO `region` VALUES ('150826', '杭锦后旗', '150800');
INSERT INTO `region` VALUES ('150901', '市辖区', '150900');
INSERT INTO `region` VALUES ('150902', '集宁区', '150900');
INSERT INTO `region` VALUES ('150921', '卓资县', '150900');
INSERT INTO `region` VALUES ('150922', '化德县', '150900');
INSERT INTO `region` VALUES ('150923', '商都县', '150900');
INSERT INTO `region` VALUES ('150924', '兴和县', '150900');
INSERT INTO `region` VALUES ('150925', '凉城县', '150900');
INSERT INTO `region` VALUES ('150926', '察哈尔右翼前旗', '150900');
INSERT INTO `region` VALUES ('150927', '察哈尔右翼中旗', '150900');
INSERT INTO `region` VALUES ('150928', '察哈尔右翼后旗', '150900');
INSERT INTO `region` VALUES ('150929', '四子王旗', '150900');
INSERT INTO `region` VALUES ('150981', '丰镇市', '150900');
INSERT INTO `region` VALUES ('152201', '乌兰浩特市', '152200');
INSERT INTO `region` VALUES ('152202', '阿尔山市', '152200');
INSERT INTO `region` VALUES ('152221', '科尔沁右翼前旗', '152200');
INSERT INTO `region` VALUES ('152222', '科尔沁右翼中旗', '152200');
INSERT INTO `region` VALUES ('152223', '扎赉特旗', '152200');
INSERT INTO `region` VALUES ('152224', '突泉县', '152200');
INSERT INTO `region` VALUES ('152501', '二连浩特市', '152500');
INSERT INTO `region` VALUES ('152502', '锡林浩特市', '152500');
INSERT INTO `region` VALUES ('152522', '阿巴嘎旗', '152500');
INSERT INTO `region` VALUES ('152523', '苏尼特左旗', '152500');
INSERT INTO `region` VALUES ('152524', '苏尼特右旗', '152500');
INSERT INTO `region` VALUES ('152525', '东乌珠穆沁旗', '152500');
INSERT INTO `region` VALUES ('152526', '西乌珠穆沁旗', '152500');
INSERT INTO `region` VALUES ('152527', '太仆寺旗', '152500');
INSERT INTO `region` VALUES ('152528', '镶黄旗', '152500');
INSERT INTO `region` VALUES ('152529', '正镶白旗', '152500');
INSERT INTO `region` VALUES ('152530', '正蓝旗', '152500');
INSERT INTO `region` VALUES ('152531', '多伦县', '152500');
INSERT INTO `region` VALUES ('152921', '阿拉善左旗', '152900');
INSERT INTO `region` VALUES ('152922', '阿拉善右旗', '152900');
INSERT INTO `region` VALUES ('152923', '额济纳旗', '152900');
INSERT INTO `region` VALUES ('210101', '市辖区', '210100');
INSERT INTO `region` VALUES ('210102', '和平区', '210100');
INSERT INTO `region` VALUES ('210103', '沈河区', '210100');
INSERT INTO `region` VALUES ('210104', '大东区', '210100');
INSERT INTO `region` VALUES ('210105', '皇姑区', '210100');
INSERT INTO `region` VALUES ('210106', '铁西区', '210100');
INSERT INTO `region` VALUES ('210111', '苏家屯区', '210100');
INSERT INTO `region` VALUES ('210112', '东陵区', '210100');
INSERT INTO `region` VALUES ('210113', '新城子区', '210100');
INSERT INTO `region` VALUES ('210114', '于洪区', '210100');
INSERT INTO `region` VALUES ('210122', '辽中县', '210100');
INSERT INTO `region` VALUES ('210123', '康平县', '210100');
INSERT INTO `region` VALUES ('210124', '法库县', '210100');
INSERT INTO `region` VALUES ('210181', '新民市', '210100');
INSERT INTO `region` VALUES ('210201', '市辖区', '210200');
INSERT INTO `region` VALUES ('210202', '中山区', '210200');
INSERT INTO `region` VALUES ('210203', '西岗区', '210200');
INSERT INTO `region` VALUES ('210204', '沙河口区', '210200');
INSERT INTO `region` VALUES ('210211', '甘井子区', '210200');
INSERT INTO `region` VALUES ('210212', '旅顺口区', '210200');
INSERT INTO `region` VALUES ('210213', '金州区', '210200');
INSERT INTO `region` VALUES ('210224', '长海县', '210200');
INSERT INTO `region` VALUES ('210281', '瓦房店市', '210200');
INSERT INTO `region` VALUES ('210282', '普兰店市', '210200');
INSERT INTO `region` VALUES ('210283', '庄河市', '210200');
INSERT INTO `region` VALUES ('210301', '市辖区', '210300');
INSERT INTO `region` VALUES ('210302', '铁东区', '210300');
INSERT INTO `region` VALUES ('210303', '铁西区', '210300');
INSERT INTO `region` VALUES ('210304', '立山区', '210300');
INSERT INTO `region` VALUES ('210311', '千山区', '210300');
INSERT INTO `region` VALUES ('210321', '台安县', '210300');
INSERT INTO `region` VALUES ('210323', '岫岩满族自治县', '210300');
INSERT INTO `region` VALUES ('210381', '海城市', '210300');
INSERT INTO `region` VALUES ('210401', '市辖区', '210400');
INSERT INTO `region` VALUES ('210402', '新抚区', '210400');
INSERT INTO `region` VALUES ('210403', '东洲区', '210400');
INSERT INTO `region` VALUES ('210404', '望花区', '210400');
INSERT INTO `region` VALUES ('210411', '顺城区', '210400');
INSERT INTO `region` VALUES ('210421', '抚顺县', '210400');
INSERT INTO `region` VALUES ('210422', '新宾满族自治县', '210400');
INSERT INTO `region` VALUES ('210423', '清原满族自治县', '210400');
INSERT INTO `region` VALUES ('210501', '市辖区', '210500');
INSERT INTO `region` VALUES ('210502', '平山区', '210500');
INSERT INTO `region` VALUES ('210503', '溪湖区', '210500');
INSERT INTO `region` VALUES ('210504', '明山区', '210500');
INSERT INTO `region` VALUES ('210505', '南芬区', '210500');
INSERT INTO `region` VALUES ('210521', '本溪满族自治县', '210500');
INSERT INTO `region` VALUES ('210522', '桓仁满族自治县', '210500');
INSERT INTO `region` VALUES ('210601', '市辖区', '210600');
INSERT INTO `region` VALUES ('210602', '元宝区', '210600');
INSERT INTO `region` VALUES ('210603', '振兴区', '210600');
INSERT INTO `region` VALUES ('210604', '振安区', '210600');
INSERT INTO `region` VALUES ('210624', '宽甸满族自治县', '210600');
INSERT INTO `region` VALUES ('210681', '东港市', '210600');
INSERT INTO `region` VALUES ('210682', '凤城市', '210600');
INSERT INTO `region` VALUES ('210701', '市辖区', '210700');
INSERT INTO `region` VALUES ('210702', '古塔区', '210700');
INSERT INTO `region` VALUES ('210703', '凌河区', '210700');
INSERT INTO `region` VALUES ('210711', '太和区', '210700');
INSERT INTO `region` VALUES ('210726', '黑山县', '210700');
INSERT INTO `region` VALUES ('210727', '义　县', '210700');
INSERT INTO `region` VALUES ('210781', '凌海市', '210700');
INSERT INTO `region` VALUES ('210782', '北宁市', '210700');
INSERT INTO `region` VALUES ('210801', '市辖区', '210800');
INSERT INTO `region` VALUES ('210802', '站前区', '210800');
INSERT INTO `region` VALUES ('210803', '西市区', '210800');
INSERT INTO `region` VALUES ('210804', '鲅鱼圈区', '210800');
INSERT INTO `region` VALUES ('210811', '老边区', '210800');
INSERT INTO `region` VALUES ('210881', '盖州市', '210800');
INSERT INTO `region` VALUES ('210882', '大石桥市', '210800');
INSERT INTO `region` VALUES ('210901', '市辖区', '210900');
INSERT INTO `region` VALUES ('210902', '海州区', '210900');
INSERT INTO `region` VALUES ('210903', '新邱区', '210900');
INSERT INTO `region` VALUES ('210904', '太平区', '210900');
INSERT INTO `region` VALUES ('210905', '清河门区', '210900');
INSERT INTO `region` VALUES ('210911', '细河区', '210900');
INSERT INTO `region` VALUES ('210921', '阜新蒙古族自治县', '210900');
INSERT INTO `region` VALUES ('210922', '彰武县', '210900');
INSERT INTO `region` VALUES ('211001', '市辖区', '211000');
INSERT INTO `region` VALUES ('211002', '白塔区', '211000');
INSERT INTO `region` VALUES ('211003', '文圣区', '211000');
INSERT INTO `region` VALUES ('211004', '宏伟区', '211000');
INSERT INTO `region` VALUES ('211005', '弓长岭区', '211000');
INSERT INTO `region` VALUES ('211011', '太子河区', '211000');
INSERT INTO `region` VALUES ('211021', '辽阳县', '211000');
INSERT INTO `region` VALUES ('211081', '灯塔市', '211000');
INSERT INTO `region` VALUES ('211101', '市辖区', '211100');
INSERT INTO `region` VALUES ('211102', '双台子区', '211100');
INSERT INTO `region` VALUES ('211103', '兴隆台区', '211100');
INSERT INTO `region` VALUES ('211121', '大洼县', '211100');
INSERT INTO `region` VALUES ('211122', '盘山县', '211100');
INSERT INTO `region` VALUES ('211201', '市辖区', '211200');
INSERT INTO `region` VALUES ('211202', '银州区', '211200');
INSERT INTO `region` VALUES ('211204', '清河区', '211200');
INSERT INTO `region` VALUES ('211221', '铁岭县', '211200');
INSERT INTO `region` VALUES ('211223', '西丰县', '211200');
INSERT INTO `region` VALUES ('211224', '昌图县', '211200');
INSERT INTO `region` VALUES ('211281', '调兵山市', '211200');
INSERT INTO `region` VALUES ('211282', '开原市', '211200');
INSERT INTO `region` VALUES ('211301', '市辖区', '211300');
INSERT INTO `region` VALUES ('211302', '双塔区', '211300');
INSERT INTO `region` VALUES ('211303', '龙城区', '211300');
INSERT INTO `region` VALUES ('211321', '朝阳县', '211300');
INSERT INTO `region` VALUES ('211322', '建平县', '211300');
INSERT INTO `region` VALUES ('211324', '喀喇沁左翼蒙古族自治县', '211300');
INSERT INTO `region` VALUES ('211381', '北票市', '211300');
INSERT INTO `region` VALUES ('211382', '凌源市', '211300');
INSERT INTO `region` VALUES ('211401', '市辖区', '211400');
INSERT INTO `region` VALUES ('211402', '连山区', '211400');
INSERT INTO `region` VALUES ('211403', '龙港区', '211400');
INSERT INTO `region` VALUES ('211404', '南票区', '211400');
INSERT INTO `region` VALUES ('211421', '绥中县', '211400');
INSERT INTO `region` VALUES ('211422', '建昌县', '211400');
INSERT INTO `region` VALUES ('211481', '兴城市', '211400');
INSERT INTO `region` VALUES ('220101', '市辖区', '220100');
INSERT INTO `region` VALUES ('220102', '南关区', '220100');
INSERT INTO `region` VALUES ('220103', '宽城区', '220100');
INSERT INTO `region` VALUES ('220104', '朝阳区', '220100');
INSERT INTO `region` VALUES ('220105', '二道区', '220100');
INSERT INTO `region` VALUES ('220106', '绿园区', '220100');
INSERT INTO `region` VALUES ('220112', '双阳区', '220100');
INSERT INTO `region` VALUES ('220122', '农安县', '220100');
INSERT INTO `region` VALUES ('220181', '九台市', '220100');
INSERT INTO `region` VALUES ('220182', '榆树市', '220100');
INSERT INTO `region` VALUES ('220183', '德惠市', '220100');
INSERT INTO `region` VALUES ('220201', '市辖区', '220200');
INSERT INTO `region` VALUES ('220202', '昌邑区', '220200');
INSERT INTO `region` VALUES ('220203', '龙潭区', '220200');
INSERT INTO `region` VALUES ('220204', '船营区', '220200');
INSERT INTO `region` VALUES ('220211', '丰满区', '220200');
INSERT INTO `region` VALUES ('220221', '永吉县', '220200');
INSERT INTO `region` VALUES ('220281', '蛟河市', '220200');
INSERT INTO `region` VALUES ('220282', '桦甸市', '220200');
INSERT INTO `region` VALUES ('220283', '舒兰市', '220200');
INSERT INTO `region` VALUES ('220284', '磐石市', '220200');
INSERT INTO `region` VALUES ('220301', '市辖区', '220300');
INSERT INTO `region` VALUES ('220302', '铁西区', '220300');
INSERT INTO `region` VALUES ('220303', '铁东区', '220300');
INSERT INTO `region` VALUES ('220322', '梨树县', '220300');
INSERT INTO `region` VALUES ('220323', '伊通满族自治县', '220300');
INSERT INTO `region` VALUES ('220381', '公主岭市', '220300');
INSERT INTO `region` VALUES ('220382', '双辽市', '220300');
INSERT INTO `region` VALUES ('220401', '市辖区', '220400');
INSERT INTO `region` VALUES ('220402', '龙山区', '220400');
INSERT INTO `region` VALUES ('220403', '西安区', '220400');
INSERT INTO `region` VALUES ('220421', '东丰县', '220400');
INSERT INTO `region` VALUES ('220422', '东辽县', '220400');
INSERT INTO `region` VALUES ('220501', '市辖区', '220500');
INSERT INTO `region` VALUES ('220502', '东昌区', '220500');
INSERT INTO `region` VALUES ('220503', '二道江区', '220500');
INSERT INTO `region` VALUES ('220521', '通化县', '220500');
INSERT INTO `region` VALUES ('220523', '辉南县', '220500');
INSERT INTO `region` VALUES ('220524', '柳河县', '220500');
INSERT INTO `region` VALUES ('220581', '梅河口市', '220500');
INSERT INTO `region` VALUES ('220582', '集安市', '220500');
INSERT INTO `region` VALUES ('220601', '市辖区', '220600');
INSERT INTO `region` VALUES ('220602', '八道江区', '220600');
INSERT INTO `region` VALUES ('220621', '抚松县', '220600');
INSERT INTO `region` VALUES ('220622', '靖宇县', '220600');
INSERT INTO `region` VALUES ('220623', '长白朝鲜族自治县', '220600');
INSERT INTO `region` VALUES ('220625', '江源县', '220600');
INSERT INTO `region` VALUES ('220681', '临江市', '220600');
INSERT INTO `region` VALUES ('220701', '市辖区', '220700');
INSERT INTO `region` VALUES ('220702', '宁江区', '220700');
INSERT INTO `region` VALUES ('220721', '前郭尔罗斯蒙古族自治县', '220700');
INSERT INTO `region` VALUES ('220722', '长岭县', '220700');
INSERT INTO `region` VALUES ('220723', '乾安县', '220700');
INSERT INTO `region` VALUES ('220724', '扶余县', '220700');
INSERT INTO `region` VALUES ('220801', '市辖区', '220800');
INSERT INTO `region` VALUES ('220802', '洮北区', '220800');
INSERT INTO `region` VALUES ('220821', '镇赉县', '220800');
INSERT INTO `region` VALUES ('220822', '通榆县', '220800');
INSERT INTO `region` VALUES ('220881', '洮南市', '220800');
INSERT INTO `region` VALUES ('220882', '大安市', '220800');
INSERT INTO `region` VALUES ('222401', '延吉市', '222400');
INSERT INTO `region` VALUES ('222402', '图们市', '222400');
INSERT INTO `region` VALUES ('222403', '敦化市', '222400');
INSERT INTO `region` VALUES ('222404', '珲春市', '222400');
INSERT INTO `region` VALUES ('222405', '龙井市', '222400');
INSERT INTO `region` VALUES ('222406', '和龙市', '222400');
INSERT INTO `region` VALUES ('222424', '汪清县', '222400');
INSERT INTO `region` VALUES ('222426', '安图县', '222400');
INSERT INTO `region` VALUES ('230101', '市辖区', '230100');
INSERT INTO `region` VALUES ('230102', '道里区', '230100');
INSERT INTO `region` VALUES ('230103', '南岗区', '230100');
INSERT INTO `region` VALUES ('230104', '道外区', '230100');
INSERT INTO `region` VALUES ('230106', '香坊区', '230100');
INSERT INTO `region` VALUES ('230107', '动力区', '230100');
INSERT INTO `region` VALUES ('230108', '平房区', '230100');
INSERT INTO `region` VALUES ('230109', '松北区', '230100');
INSERT INTO `region` VALUES ('230111', '呼兰区', '230100');
INSERT INTO `region` VALUES ('230123', '依兰县', '230100');
INSERT INTO `region` VALUES ('230124', '方正县', '230100');
INSERT INTO `region` VALUES ('230125', '宾　县', '230100');
INSERT INTO `region` VALUES ('230126', '巴彦县', '230100');
INSERT INTO `region` VALUES ('230127', '木兰县', '230100');
INSERT INTO `region` VALUES ('230128', '通河县', '230100');
INSERT INTO `region` VALUES ('230129', '延寿县', '230100');
INSERT INTO `region` VALUES ('230181', '阿城市', '230100');
INSERT INTO `region` VALUES ('230182', '双城市', '230100');
INSERT INTO `region` VALUES ('230183', '尚志市', '230100');
INSERT INTO `region` VALUES ('230184', '五常市', '230100');
INSERT INTO `region` VALUES ('230201', '市辖区', '230200');
INSERT INTO `region` VALUES ('230202', '龙沙区', '230200');
INSERT INTO `region` VALUES ('230203', '建华区', '230200');
INSERT INTO `region` VALUES ('230204', '铁锋区', '230200');
INSERT INTO `region` VALUES ('230205', '昂昂溪区', '230200');
INSERT INTO `region` VALUES ('230206', '富拉尔基区', '230200');
INSERT INTO `region` VALUES ('230207', '碾子山区', '230200');
INSERT INTO `region` VALUES ('230208', '梅里斯达斡尔族区', '230200');
INSERT INTO `region` VALUES ('230221', '龙江县', '230200');
INSERT INTO `region` VALUES ('230223', '依安县', '230200');
INSERT INTO `region` VALUES ('230224', '泰来县', '230200');
INSERT INTO `region` VALUES ('230225', '甘南县', '230200');
INSERT INTO `region` VALUES ('230227', '富裕县', '230200');
INSERT INTO `region` VALUES ('230229', '克山县', '230200');
INSERT INTO `region` VALUES ('230230', '克东县', '230200');
INSERT INTO `region` VALUES ('230231', '拜泉县', '230200');
INSERT INTO `region` VALUES ('230281', '讷河市', '230200');
INSERT INTO `region` VALUES ('230301', '市辖区', '230300');
INSERT INTO `region` VALUES ('230302', '鸡冠区', '230300');
INSERT INTO `region` VALUES ('230303', '恒山区', '230300');
INSERT INTO `region` VALUES ('230304', '滴道区', '230300');
INSERT INTO `region` VALUES ('230305', '梨树区', '230300');
INSERT INTO `region` VALUES ('230306', '城子河区', '230300');
INSERT INTO `region` VALUES ('230307', '麻山区', '230300');
INSERT INTO `region` VALUES ('230321', '鸡东县', '230300');
INSERT INTO `region` VALUES ('230381', '虎林市', '230300');
INSERT INTO `region` VALUES ('230382', '密山市', '230300');
INSERT INTO `region` VALUES ('230401', '市辖区', '230400');
INSERT INTO `region` VALUES ('230402', '向阳区', '230400');
INSERT INTO `region` VALUES ('230403', '工农区', '230400');
INSERT INTO `region` VALUES ('230404', '南山区', '230400');
INSERT INTO `region` VALUES ('230405', '兴安区', '230400');
INSERT INTO `region` VALUES ('230406', '东山区', '230400');
INSERT INTO `region` VALUES ('230407', '兴山区', '230400');
INSERT INTO `region` VALUES ('230421', '萝北县', '230400');
INSERT INTO `region` VALUES ('230422', '绥滨县', '230400');
INSERT INTO `region` VALUES ('230501', '市辖区', '230500');
INSERT INTO `region` VALUES ('230502', '尖山区', '230500');
INSERT INTO `region` VALUES ('230503', '岭东区', '230500');
INSERT INTO `region` VALUES ('230505', '四方台区', '230500');
INSERT INTO `region` VALUES ('230506', '宝山区', '230500');
INSERT INTO `region` VALUES ('230521', '集贤县', '230500');
INSERT INTO `region` VALUES ('230522', '友谊县', '230500');
INSERT INTO `region` VALUES ('230523', '宝清县', '230500');
INSERT INTO `region` VALUES ('230524', '饶河县', '230500');
INSERT INTO `region` VALUES ('230601', '市辖区', '230600');
INSERT INTO `region` VALUES ('230602', '萨尔图区', '230600');
INSERT INTO `region` VALUES ('230603', '龙凤区', '230600');
INSERT INTO `region` VALUES ('230604', '让胡路区', '230600');
INSERT INTO `region` VALUES ('230605', '红岗区', '230600');
INSERT INTO `region` VALUES ('230606', '大同区', '230600');
INSERT INTO `region` VALUES ('230621', '肇州县', '230600');
INSERT INTO `region` VALUES ('230622', '肇源县', '230600');
INSERT INTO `region` VALUES ('230623', '林甸县', '230600');
INSERT INTO `region` VALUES ('230624', '杜尔伯特蒙古族自治县', '230600');
INSERT INTO `region` VALUES ('230701', '市辖区', '230700');
INSERT INTO `region` VALUES ('230702', '伊春区', '230700');
INSERT INTO `region` VALUES ('230703', '南岔区', '230700');
INSERT INTO `region` VALUES ('230704', '友好区', '230700');
INSERT INTO `region` VALUES ('230705', '西林区', '230700');
INSERT INTO `region` VALUES ('230706', '翠峦区', '230700');
INSERT INTO `region` VALUES ('230707', '新青区', '230700');
INSERT INTO `region` VALUES ('230708', '美溪区', '230700');
INSERT INTO `region` VALUES ('230709', '金山屯区', '230700');
INSERT INTO `region` VALUES ('230710', '五营区', '230700');
INSERT INTO `region` VALUES ('230711', '乌马河区', '230700');
INSERT INTO `region` VALUES ('230712', '汤旺河区', '230700');
INSERT INTO `region` VALUES ('230713', '带岭区', '230700');
INSERT INTO `region` VALUES ('230714', '乌伊岭区', '230700');
INSERT INTO `region` VALUES ('230715', '红星区', '230700');
INSERT INTO `region` VALUES ('230716', '上甘岭区', '230700');
INSERT INTO `region` VALUES ('230722', '嘉荫县', '230700');
INSERT INTO `region` VALUES ('230781', '铁力市', '230700');
INSERT INTO `region` VALUES ('230801', '市辖区', '230800');
INSERT INTO `region` VALUES ('230802', '永红区', '230800');
INSERT INTO `region` VALUES ('230803', '向阳区', '230800');
INSERT INTO `region` VALUES ('230804', '前进区', '230800');
INSERT INTO `region` VALUES ('230805', '东风区', '230800');
INSERT INTO `region` VALUES ('230811', '郊　区', '230800');
INSERT INTO `region` VALUES ('230822', '桦南县', '230800');
INSERT INTO `region` VALUES ('230826', '桦川县', '230800');
INSERT INTO `region` VALUES ('230828', '汤原县', '230800');
INSERT INTO `region` VALUES ('230833', '抚远县', '230800');
INSERT INTO `region` VALUES ('230881', '同江市', '230800');
INSERT INTO `region` VALUES ('230882', '富锦市', '230800');
INSERT INTO `region` VALUES ('230901', '市辖区', '230900');
INSERT INTO `region` VALUES ('230902', '新兴区', '230900');
INSERT INTO `region` VALUES ('230903', '桃山区', '230900');
INSERT INTO `region` VALUES ('230904', '茄子河区', '230900');
INSERT INTO `region` VALUES ('230921', '勃利县', '230900');
INSERT INTO `region` VALUES ('231001', '市辖区', '231000');
INSERT INTO `region` VALUES ('231002', '东安区', '231000');
INSERT INTO `region` VALUES ('231003', '阳明区', '231000');
INSERT INTO `region` VALUES ('231004', '爱民区', '231000');
INSERT INTO `region` VALUES ('231005', '西安区', '231000');
INSERT INTO `region` VALUES ('231024', '东宁县', '231000');
INSERT INTO `region` VALUES ('231025', '林口县', '231000');
INSERT INTO `region` VALUES ('231081', '绥芬河市', '231000');
INSERT INTO `region` VALUES ('231083', '海林市', '231000');
INSERT INTO `region` VALUES ('231084', '宁安市', '231000');
INSERT INTO `region` VALUES ('231085', '穆棱市', '231000');
INSERT INTO `region` VALUES ('231101', '市辖区', '231100');
INSERT INTO `region` VALUES ('231102', '爱辉区', '231100');
INSERT INTO `region` VALUES ('231121', '嫩江县', '231100');
INSERT INTO `region` VALUES ('231123', '逊克县', '231100');
INSERT INTO `region` VALUES ('231124', '孙吴县', '231100');
INSERT INTO `region` VALUES ('231181', '北安市', '231100');
INSERT INTO `region` VALUES ('231182', '五大连池市', '231100');
INSERT INTO `region` VALUES ('231201', '市辖区', '231200');
INSERT INTO `region` VALUES ('231202', '北林区', '231200');
INSERT INTO `region` VALUES ('231221', '望奎县', '231200');
INSERT INTO `region` VALUES ('231222', '兰西县', '231200');
INSERT INTO `region` VALUES ('231223', '青冈县', '231200');
INSERT INTO `region` VALUES ('231224', '庆安县', '231200');
INSERT INTO `region` VALUES ('231225', '明水县', '231200');
INSERT INTO `region` VALUES ('231226', '绥棱县', '231200');
INSERT INTO `region` VALUES ('231281', '安达市', '231200');
INSERT INTO `region` VALUES ('231282', '肇东市', '231200');
INSERT INTO `region` VALUES ('231283', '海伦市', '231200');
INSERT INTO `region` VALUES ('232721', '呼玛县', '232700');
INSERT INTO `region` VALUES ('232722', '塔河县', '232700');
INSERT INTO `region` VALUES ('232723', '漠河县', '232700');
INSERT INTO `region` VALUES ('310101', '黄浦区', '310100');
INSERT INTO `region` VALUES ('310103', '卢湾区', '310100');
INSERT INTO `region` VALUES ('310104', '徐汇区', '310100');
INSERT INTO `region` VALUES ('310105', '长宁区', '310100');
INSERT INTO `region` VALUES ('310106', '静安区', '310100');
INSERT INTO `region` VALUES ('310107', '普陀区', '310100');
INSERT INTO `region` VALUES ('310108', '闸北区', '310100');
INSERT INTO `region` VALUES ('310109', '虹口区', '310100');
INSERT INTO `region` VALUES ('310110', '杨浦区', '310100');
INSERT INTO `region` VALUES ('310112', '闵行区', '310100');
INSERT INTO `region` VALUES ('310113', '宝山区', '310100');
INSERT INTO `region` VALUES ('310114', '嘉定区', '310100');
INSERT INTO `region` VALUES ('310115', '浦东新区', '310100');
INSERT INTO `region` VALUES ('310116', '金山区', '310100');
INSERT INTO `region` VALUES ('310117', '松江区', '310100');
INSERT INTO `region` VALUES ('310118', '青浦区', '310100');
INSERT INTO `region` VALUES ('310119', '南汇区', '310100');
INSERT INTO `region` VALUES ('310120', '奉贤区', '310100');
INSERT INTO `region` VALUES ('310230', '崇明县', '310200');
INSERT INTO `region` VALUES ('320101', '市辖区', '320100');
INSERT INTO `region` VALUES ('320102', '玄武区', '320100');
INSERT INTO `region` VALUES ('320103', '白下区', '320100');
INSERT INTO `region` VALUES ('320104', '秦淮区', '320100');
INSERT INTO `region` VALUES ('320105', '建邺区', '320100');
INSERT INTO `region` VALUES ('320106', '鼓楼区', '320100');
INSERT INTO `region` VALUES ('320107', '下关区', '320100');
INSERT INTO `region` VALUES ('320111', '浦口区', '320100');
INSERT INTO `region` VALUES ('320113', '栖霞区', '320100');
INSERT INTO `region` VALUES ('320114', '雨花台区', '320100');
INSERT INTO `region` VALUES ('320115', '江宁区', '320100');
INSERT INTO `region` VALUES ('320116', '六合区', '320100');
INSERT INTO `region` VALUES ('320124', '溧水县', '320100');
INSERT INTO `region` VALUES ('320125', '高淳县', '320100');
INSERT INTO `region` VALUES ('320201', '市辖区', '320200');
INSERT INTO `region` VALUES ('320202', '崇安区', '320200');
INSERT INTO `region` VALUES ('320203', '南长区', '320200');
INSERT INTO `region` VALUES ('320204', '北塘区', '320200');
INSERT INTO `region` VALUES ('320205', '锡山区', '320200');
INSERT INTO `region` VALUES ('320206', '惠山区', '320200');
INSERT INTO `region` VALUES ('320211', '滨湖区', '320200');
INSERT INTO `region` VALUES ('320281', '江阴市', '320200');
INSERT INTO `region` VALUES ('320282', '宜兴市', '320200');
INSERT INTO `region` VALUES ('320301', '市辖区', '320300');
INSERT INTO `region` VALUES ('320302', '鼓楼区', '320300');
INSERT INTO `region` VALUES ('320303', '云龙区', '320300');
INSERT INTO `region` VALUES ('320304', '九里区', '320300');
INSERT INTO `region` VALUES ('320305', '贾汪区', '320300');
INSERT INTO `region` VALUES ('320311', '泉山区', '320300');
INSERT INTO `region` VALUES ('320321', '丰　县', '320300');
INSERT INTO `region` VALUES ('320322', '沛　县', '320300');
INSERT INTO `region` VALUES ('320323', '铜山县', '320300');
INSERT INTO `region` VALUES ('320324', '睢宁县', '320300');
INSERT INTO `region` VALUES ('320381', '新沂市', '320300');
INSERT INTO `region` VALUES ('320382', '邳州市', '320300');
INSERT INTO `region` VALUES ('320401', '市辖区', '320400');
INSERT INTO `region` VALUES ('320402', '天宁区', '320400');
INSERT INTO `region` VALUES ('320404', '钟楼区', '320400');
INSERT INTO `region` VALUES ('320405', '戚墅堰区', '320400');
INSERT INTO `region` VALUES ('320411', '新北区', '320400');
INSERT INTO `region` VALUES ('320412', '武进区', '320400');
INSERT INTO `region` VALUES ('320481', '溧阳市', '320400');
INSERT INTO `region` VALUES ('320482', '金坛市', '320400');
INSERT INTO `region` VALUES ('320501', '市辖区', '320500');
INSERT INTO `region` VALUES ('320502', '沧浪区', '320500');
INSERT INTO `region` VALUES ('320503', '平江区', '320500');
INSERT INTO `region` VALUES ('320504', '金阊区', '320500');
INSERT INTO `region` VALUES ('320505', '虎丘区', '320500');
INSERT INTO `region` VALUES ('320506', '吴中区', '320500');
INSERT INTO `region` VALUES ('320507', '相城区', '320500');
INSERT INTO `region` VALUES ('320581', '常熟市', '320500');
INSERT INTO `region` VALUES ('320582', '张家港市', '320500');
INSERT INTO `region` VALUES ('320583', '昆山市', '320500');
INSERT INTO `region` VALUES ('320584', '吴江市', '320500');
INSERT INTO `region` VALUES ('320585', '太仓市', '320500');
INSERT INTO `region` VALUES ('320601', '市辖区', '320600');
INSERT INTO `region` VALUES ('320602', '崇川区', '320600');
INSERT INTO `region` VALUES ('320611', '港闸区', '320600');
INSERT INTO `region` VALUES ('320621', '海安县', '320600');
INSERT INTO `region` VALUES ('320623', '如东县', '320600');
INSERT INTO `region` VALUES ('320681', '启东市', '320600');
INSERT INTO `region` VALUES ('320682', '如皋市', '320600');
INSERT INTO `region` VALUES ('320683', '通州市', '320600');
INSERT INTO `region` VALUES ('320684', '海门市', '320600');
INSERT INTO `region` VALUES ('320701', '市辖区', '320700');
INSERT INTO `region` VALUES ('320703', '连云区', '320700');
INSERT INTO `region` VALUES ('320705', '新浦区', '320700');
INSERT INTO `region` VALUES ('320706', '海州区', '320700');
INSERT INTO `region` VALUES ('320721', '赣榆县', '320700');
INSERT INTO `region` VALUES ('320722', '东海县', '320700');
INSERT INTO `region` VALUES ('320723', '灌云县', '320700');
INSERT INTO `region` VALUES ('320724', '灌南县', '320700');
INSERT INTO `region` VALUES ('320801', '市辖区', '320800');
INSERT INTO `region` VALUES ('320802', '清河区', '320800');
INSERT INTO `region` VALUES ('320803', '楚州区', '320800');
INSERT INTO `region` VALUES ('320804', '淮阴区', '320800');
INSERT INTO `region` VALUES ('320811', '清浦区', '320800');
INSERT INTO `region` VALUES ('320826', '涟水县', '320800');
INSERT INTO `region` VALUES ('320829', '洪泽县', '320800');
INSERT INTO `region` VALUES ('320830', '盱眙县', '320800');
INSERT INTO `region` VALUES ('320831', '金湖县', '320800');
INSERT INTO `region` VALUES ('320901', '市辖区', '320900');
INSERT INTO `region` VALUES ('320902', '亭湖区', '320900');
INSERT INTO `region` VALUES ('320903', '盐都区', '320900');
INSERT INTO `region` VALUES ('320921', '响水县', '320900');
INSERT INTO `region` VALUES ('320922', '滨海县', '320900');
INSERT INTO `region` VALUES ('320923', '阜宁县', '320900');
INSERT INTO `region` VALUES ('320924', '射阳县', '320900');
INSERT INTO `region` VALUES ('320925', '建湖县', '320900');
INSERT INTO `region` VALUES ('320981', '东台市', '320900');
INSERT INTO `region` VALUES ('320982', '大丰市', '320900');
INSERT INTO `region` VALUES ('321001', '市辖区', '321000');
INSERT INTO `region` VALUES ('321002', '广陵区', '321000');
INSERT INTO `region` VALUES ('321003', '邗江区', '321000');
INSERT INTO `region` VALUES ('321011', '郊　区', '321000');
INSERT INTO `region` VALUES ('321023', '宝应县', '321000');
INSERT INTO `region` VALUES ('321081', '仪征市', '321000');
INSERT INTO `region` VALUES ('321084', '高邮市', '321000');
INSERT INTO `region` VALUES ('321088', '江都市', '321000');
INSERT INTO `region` VALUES ('321101', '市辖区', '321100');
INSERT INTO `region` VALUES ('321102', '京口区', '321100');
INSERT INTO `region` VALUES ('321111', '润州区', '321100');
INSERT INTO `region` VALUES ('321112', '丹徒区', '321100');
INSERT INTO `region` VALUES ('321181', '丹阳市', '321100');
INSERT INTO `region` VALUES ('321182', '扬中市', '321100');
INSERT INTO `region` VALUES ('321183', '句容市', '321100');
INSERT INTO `region` VALUES ('321201', '市辖区', '321200');
INSERT INTO `region` VALUES ('321202', '海陵区', '321200');
INSERT INTO `region` VALUES ('321203', '高港区', '321200');
INSERT INTO `region` VALUES ('321281', '兴化市', '321200');
INSERT INTO `region` VALUES ('321282', '靖江市', '321200');
INSERT INTO `region` VALUES ('321283', '泰兴市', '321200');
INSERT INTO `region` VALUES ('321284', '姜堰市', '321200');
INSERT INTO `region` VALUES ('321301', '市辖区', '321300');
INSERT INTO `region` VALUES ('321302', '宿城区', '321300');
INSERT INTO `region` VALUES ('321311', '宿豫区', '321300');
INSERT INTO `region` VALUES ('321322', '沭阳县', '321300');
INSERT INTO `region` VALUES ('321323', '泗阳县', '321300');
INSERT INTO `region` VALUES ('321324', '泗洪县', '321300');
INSERT INTO `region` VALUES ('330101', '市辖区', '330100');
INSERT INTO `region` VALUES ('330102', '上城区', '330100');
INSERT INTO `region` VALUES ('330103', '下城区', '330100');
INSERT INTO `region` VALUES ('330104', '江干区', '330100');
INSERT INTO `region` VALUES ('330105', '拱墅区', '330100');
INSERT INTO `region` VALUES ('330106', '西湖区', '330100');
INSERT INTO `region` VALUES ('330108', '滨江区', '330100');
INSERT INTO `region` VALUES ('330109', '萧山区', '330100');
INSERT INTO `region` VALUES ('330110', '余杭区', '330100');
INSERT INTO `region` VALUES ('330122', '桐庐县', '330100');
INSERT INTO `region` VALUES ('330127', '淳安县', '330100');
INSERT INTO `region` VALUES ('330182', '建德市', '330100');
INSERT INTO `region` VALUES ('330183', '富阳市', '330100');
INSERT INTO `region` VALUES ('330185', '临安市', '330100');
INSERT INTO `region` VALUES ('330201', '市辖区', '330200');
INSERT INTO `region` VALUES ('330203', '海曙区', '330200');
INSERT INTO `region` VALUES ('330204', '江东区', '330200');
INSERT INTO `region` VALUES ('330205', '江北区', '330200');
INSERT INTO `region` VALUES ('330206', '北仑区', '330200');
INSERT INTO `region` VALUES ('330211', '镇海区', '330200');
INSERT INTO `region` VALUES ('330212', '鄞州区', '330200');
INSERT INTO `region` VALUES ('330225', '象山县', '330200');
INSERT INTO `region` VALUES ('330226', '宁海县', '330200');
INSERT INTO `region` VALUES ('330281', '余姚市', '330200');
INSERT INTO `region` VALUES ('330282', '慈溪市', '330200');
INSERT INTO `region` VALUES ('330283', '奉化市', '330200');
INSERT INTO `region` VALUES ('330301', '市辖区', '330300');
INSERT INTO `region` VALUES ('330302', '鹿城区', '330300');
INSERT INTO `region` VALUES ('330303', '龙湾区', '330300');
INSERT INTO `region` VALUES ('330304', '瓯海区', '330300');
INSERT INTO `region` VALUES ('330322', '洞头县', '330300');
INSERT INTO `region` VALUES ('330324', '永嘉县', '330300');
INSERT INTO `region` VALUES ('330326', '平阳县', '330300');
INSERT INTO `region` VALUES ('330327', '苍南县', '330300');
INSERT INTO `region` VALUES ('330328', '文成县', '330300');
INSERT INTO `region` VALUES ('330329', '泰顺县', '330300');
INSERT INTO `region` VALUES ('330381', '瑞安市', '330300');
INSERT INTO `region` VALUES ('330382', '乐清市', '330300');
INSERT INTO `region` VALUES ('330401', '市辖区', '330400');
INSERT INTO `region` VALUES ('330402', '秀城区', '330400');
INSERT INTO `region` VALUES ('330411', '秀洲区', '330400');
INSERT INTO `region` VALUES ('330421', '嘉善县', '330400');
INSERT INTO `region` VALUES ('330424', '海盐县', '330400');
INSERT INTO `region` VALUES ('330481', '海宁市', '330400');
INSERT INTO `region` VALUES ('330482', '平湖市', '330400');
INSERT INTO `region` VALUES ('330483', '桐乡市', '330400');
INSERT INTO `region` VALUES ('330501', '市辖区', '330500');
INSERT INTO `region` VALUES ('330502', '吴兴区', '330500');
INSERT INTO `region` VALUES ('330503', '南浔区', '330500');
INSERT INTO `region` VALUES ('330521', '德清县', '330500');
INSERT INTO `region` VALUES ('330522', '长兴县', '330500');
INSERT INTO `region` VALUES ('330523', '安吉县', '330500');
INSERT INTO `region` VALUES ('330601', '市辖区', '330600');
INSERT INTO `region` VALUES ('330602', '越城区', '330600');
INSERT INTO `region` VALUES ('330621', '绍兴县', '330600');
INSERT INTO `region` VALUES ('330624', '新昌县', '330600');
INSERT INTO `region` VALUES ('330681', '诸暨市', '330600');
INSERT INTO `region` VALUES ('330682', '上虞市', '330600');
INSERT INTO `region` VALUES ('330683', '嵊州市', '330600');
INSERT INTO `region` VALUES ('330701', '市辖区', '330700');
INSERT INTO `region` VALUES ('330702', '婺城区', '330700');
INSERT INTO `region` VALUES ('330703', '金东区', '330700');
INSERT INTO `region` VALUES ('330723', '武义县', '330700');
INSERT INTO `region` VALUES ('330726', '浦江县', '330700');
INSERT INTO `region` VALUES ('330727', '磐安县', '330700');
INSERT INTO `region` VALUES ('330781', '兰溪市', '330700');
INSERT INTO `region` VALUES ('330782', '义乌市', '330700');
INSERT INTO `region` VALUES ('330783', '东阳市', '330700');
INSERT INTO `region` VALUES ('330784', '永康市', '330700');
INSERT INTO `region` VALUES ('330801', '市辖区', '330800');
INSERT INTO `region` VALUES ('330802', '柯城区', '330800');
INSERT INTO `region` VALUES ('330803', '衢江区', '330800');
INSERT INTO `region` VALUES ('330822', '常山县', '330800');
INSERT INTO `region` VALUES ('330824', '开化县', '330800');
INSERT INTO `region` VALUES ('330825', '龙游县', '330800');
INSERT INTO `region` VALUES ('330881', '江山市', '330800');
INSERT INTO `region` VALUES ('330901', '市辖区', '330900');
INSERT INTO `region` VALUES ('330902', '定海区', '330900');
INSERT INTO `region` VALUES ('330903', '普陀区', '330900');
INSERT INTO `region` VALUES ('330921', '岱山县', '330900');
INSERT INTO `region` VALUES ('330922', '嵊泗县', '330900');
INSERT INTO `region` VALUES ('331001', '市辖区', '331000');
INSERT INTO `region` VALUES ('331002', '椒江区', '331000');
INSERT INTO `region` VALUES ('331003', '黄岩区', '331000');
INSERT INTO `region` VALUES ('331004', '路桥区', '331000');
INSERT INTO `region` VALUES ('331021', '玉环县', '331000');
INSERT INTO `region` VALUES ('331022', '三门县', '331000');
INSERT INTO `region` VALUES ('331023', '天台县', '331000');
INSERT INTO `region` VALUES ('331024', '仙居县', '331000');
INSERT INTO `region` VALUES ('331081', '温岭市', '331000');
INSERT INTO `region` VALUES ('331082', '临海市', '331000');
INSERT INTO `region` VALUES ('331101', '市辖区', '331100');
INSERT INTO `region` VALUES ('331102', '莲都区', '331100');
INSERT INTO `region` VALUES ('331121', '青田县', '331100');
INSERT INTO `region` VALUES ('331122', '缙云县', '331100');
INSERT INTO `region` VALUES ('331123', '遂昌县', '331100');
INSERT INTO `region` VALUES ('331124', '松阳县', '331100');
INSERT INTO `region` VALUES ('331125', '云和县', '331100');
INSERT INTO `region` VALUES ('331126', '庆元县', '331100');
INSERT INTO `region` VALUES ('331127', '景宁畲族自治县', '331100');
INSERT INTO `region` VALUES ('331181', '龙泉市', '331100');
INSERT INTO `region` VALUES ('340101', '市辖区', '340100');
INSERT INTO `region` VALUES ('340102', '瑶海区', '340100');
INSERT INTO `region` VALUES ('340103', '庐阳区', '340100');
INSERT INTO `region` VALUES ('340104', '蜀山区', '340100');
INSERT INTO `region` VALUES ('340111', '包河区', '340100');
INSERT INTO `region` VALUES ('340121', '长丰县', '340100');
INSERT INTO `region` VALUES ('340122', '肥东县', '340100');
INSERT INTO `region` VALUES ('340123', '肥西县', '340100');
INSERT INTO `region` VALUES ('340201', '市辖区', '340200');
INSERT INTO `region` VALUES ('340202', '镜湖区', '340200');
INSERT INTO `region` VALUES ('340203', '马塘区', '340200');
INSERT INTO `region` VALUES ('340204', '新芜区', '340200');
INSERT INTO `region` VALUES ('340207', '鸠江区', '340200');
INSERT INTO `region` VALUES ('340221', '芜湖县', '340200');
INSERT INTO `region` VALUES ('340222', '繁昌县', '340200');
INSERT INTO `region` VALUES ('340223', '南陵县', '340200');
INSERT INTO `region` VALUES ('340301', '市辖区', '340300');
INSERT INTO `region` VALUES ('340302', '龙子湖区', '340300');
INSERT INTO `region` VALUES ('340303', '蚌山区', '340300');
INSERT INTO `region` VALUES ('340304', '禹会区', '340300');
INSERT INTO `region` VALUES ('340311', '淮上区', '340300');
INSERT INTO `region` VALUES ('340321', '怀远县', '340300');
INSERT INTO `region` VALUES ('340322', '五河县', '340300');
INSERT INTO `region` VALUES ('340323', '固镇县', '340300');
INSERT INTO `region` VALUES ('340401', '市辖区', '340400');
INSERT INTO `region` VALUES ('340402', '大通区', '340400');
INSERT INTO `region` VALUES ('340403', '田家庵区', '340400');
INSERT INTO `region` VALUES ('340404', '谢家集区', '340400');
INSERT INTO `region` VALUES ('340405', '八公山区', '340400');
INSERT INTO `region` VALUES ('340406', '潘集区', '340400');
INSERT INTO `region` VALUES ('340421', '凤台县', '340400');
INSERT INTO `region` VALUES ('340501', '市辖区', '340500');
INSERT INTO `region` VALUES ('340502', '金家庄区', '340500');
INSERT INTO `region` VALUES ('340503', '花山区', '340500');
INSERT INTO `region` VALUES ('340504', '雨山区', '340500');
INSERT INTO `region` VALUES ('340521', '当涂县', '340500');
INSERT INTO `region` VALUES ('340601', '市辖区', '340600');
INSERT INTO `region` VALUES ('340602', '杜集区', '340600');
INSERT INTO `region` VALUES ('340603', '相山区', '340600');
INSERT INTO `region` VALUES ('340604', '烈山区', '340600');
INSERT INTO `region` VALUES ('340621', '濉溪县', '340600');
INSERT INTO `region` VALUES ('340701', '市辖区', '340700');
INSERT INTO `region` VALUES ('340702', '铜官山区', '340700');
INSERT INTO `region` VALUES ('340703', '狮子山区', '340700');
INSERT INTO `region` VALUES ('340711', '郊　区', '340700');
INSERT INTO `region` VALUES ('340721', '铜陵县', '340700');
INSERT INTO `region` VALUES ('340801', '市辖区', '340800');
INSERT INTO `region` VALUES ('340802', '迎江区', '340800');
INSERT INTO `region` VALUES ('340803', '大观区', '340800');
INSERT INTO `region` VALUES ('340811', '郊　区', '340800');
INSERT INTO `region` VALUES ('340822', '怀宁县', '340800');
INSERT INTO `region` VALUES ('340823', '枞阳县', '340800');
INSERT INTO `region` VALUES ('340824', '潜山县', '340800');
INSERT INTO `region` VALUES ('340825', '太湖县', '340800');
INSERT INTO `region` VALUES ('340826', '宿松县', '340800');
INSERT INTO `region` VALUES ('340827', '望江县', '340800');
INSERT INTO `region` VALUES ('340828', '岳西县', '340800');
INSERT INTO `region` VALUES ('340881', '桐城市', '340800');
INSERT INTO `region` VALUES ('341001', '市辖区', '341000');
INSERT INTO `region` VALUES ('341002', '屯溪区', '341000');
INSERT INTO `region` VALUES ('341003', '黄山区', '341000');
INSERT INTO `region` VALUES ('341004', '徽州区', '341000');
INSERT INTO `region` VALUES ('341021', '歙　县', '341000');
INSERT INTO `region` VALUES ('341022', '休宁县', '341000');
INSERT INTO `region` VALUES ('341023', '黟　县', '341000');
INSERT INTO `region` VALUES ('341024', '祁门县', '341000');
INSERT INTO `region` VALUES ('341101', '市辖区', '341100');
INSERT INTO `region` VALUES ('341102', '琅琊区', '341100');
INSERT INTO `region` VALUES ('341103', '南谯区', '341100');
INSERT INTO `region` VALUES ('341122', '来安县', '341100');
INSERT INTO `region` VALUES ('341124', '全椒县', '341100');
INSERT INTO `region` VALUES ('341125', '定远县', '341100');
INSERT INTO `region` VALUES ('341126', '凤阳县', '341100');
INSERT INTO `region` VALUES ('341181', '天长市', '341100');
INSERT INTO `region` VALUES ('341182', '明光市', '341100');
INSERT INTO `region` VALUES ('341201', '市辖区', '341200');
INSERT INTO `region` VALUES ('341202', '颍州区', '341200');
INSERT INTO `region` VALUES ('341203', '颍东区', '341200');
INSERT INTO `region` VALUES ('341204', '颍泉区', '341200');
INSERT INTO `region` VALUES ('341221', '临泉县', '341200');
INSERT INTO `region` VALUES ('341222', '太和县', '341200');
INSERT INTO `region` VALUES ('341225', '阜南县', '341200');
INSERT INTO `region` VALUES ('341226', '颍上县', '341200');
INSERT INTO `region` VALUES ('341282', '界首市', '341200');
INSERT INTO `region` VALUES ('341301', '市辖区', '341300');
INSERT INTO `region` VALUES ('341302', '墉桥区', '341300');
INSERT INTO `region` VALUES ('341321', '砀山县', '341300');
INSERT INTO `region` VALUES ('341322', '萧　县', '341300');
INSERT INTO `region` VALUES ('341323', '灵璧县', '341300');
INSERT INTO `region` VALUES ('341324', '泗　县', '341300');
INSERT INTO `region` VALUES ('341401', '市辖区', '341400');
INSERT INTO `region` VALUES ('341402', '居巢区', '341400');
INSERT INTO `region` VALUES ('341421', '庐江县', '341400');
INSERT INTO `region` VALUES ('341422', '无为县', '341400');
INSERT INTO `region` VALUES ('341423', '含山县', '341400');
INSERT INTO `region` VALUES ('341424', '和　县', '341400');
INSERT INTO `region` VALUES ('341501', '市辖区', '341500');
INSERT INTO `region` VALUES ('341502', '金安区', '341500');
INSERT INTO `region` VALUES ('341503', '裕安区', '341500');
INSERT INTO `region` VALUES ('341521', '寿　县', '341500');
INSERT INTO `region` VALUES ('341522', '霍邱县', '341500');
INSERT INTO `region` VALUES ('341523', '舒城县', '341500');
INSERT INTO `region` VALUES ('341524', '金寨县', '341500');
INSERT INTO `region` VALUES ('341525', '霍山县', '341500');
INSERT INTO `region` VALUES ('341601', '市辖区', '341600');
INSERT INTO `region` VALUES ('341602', '谯城区', '341600');
INSERT INTO `region` VALUES ('341621', '涡阳县', '341600');
INSERT INTO `region` VALUES ('341622', '蒙城县', '341600');
INSERT INTO `region` VALUES ('341623', '利辛县', '341600');
INSERT INTO `region` VALUES ('341701', '市辖区', '341700');
INSERT INTO `region` VALUES ('341702', '贵池区', '341700');
INSERT INTO `region` VALUES ('341721', '东至县', '341700');
INSERT INTO `region` VALUES ('341722', '石台县', '341700');
INSERT INTO `region` VALUES ('341723', '青阳县', '341700');
INSERT INTO `region` VALUES ('341801', '市辖区', '341800');
INSERT INTO `region` VALUES ('341802', '宣州区', '341800');
INSERT INTO `region` VALUES ('341821', '郎溪县', '341800');
INSERT INTO `region` VALUES ('341822', '广德县', '341800');
INSERT INTO `region` VALUES ('341823', '泾　县', '341800');
INSERT INTO `region` VALUES ('341824', '绩溪县', '341800');
INSERT INTO `region` VALUES ('341825', '旌德县', '341800');
INSERT INTO `region` VALUES ('341881', '宁国市', '341800');
INSERT INTO `region` VALUES ('350101', '市辖区', '350100');
INSERT INTO `region` VALUES ('350102', '鼓楼区', '350100');
INSERT INTO `region` VALUES ('350103', '台江区', '350100');
INSERT INTO `region` VALUES ('350104', '仓山区', '350100');
INSERT INTO `region` VALUES ('350105', '马尾区', '350100');
INSERT INTO `region` VALUES ('350111', '晋安区', '350100');
INSERT INTO `region` VALUES ('350121', '闽侯县', '350100');
INSERT INTO `region` VALUES ('350122', '连江县', '350100');
INSERT INTO `region` VALUES ('350123', '罗源县', '350100');
INSERT INTO `region` VALUES ('350124', '闽清县', '350100');
INSERT INTO `region` VALUES ('350125', '永泰县', '350100');
INSERT INTO `region` VALUES ('350128', '平潭县', '350100');
INSERT INTO `region` VALUES ('350181', '福清市', '350100');
INSERT INTO `region` VALUES ('350182', '长乐市', '350100');
INSERT INTO `region` VALUES ('350201', '市辖区', '350200');
INSERT INTO `region` VALUES ('350203', '思明区', '350200');
INSERT INTO `region` VALUES ('350205', '海沧区', '350200');
INSERT INTO `region` VALUES ('350206', '湖里区', '350200');
INSERT INTO `region` VALUES ('350211', '集美区', '350200');
INSERT INTO `region` VALUES ('350212', '同安区', '350200');
INSERT INTO `region` VALUES ('350213', '翔安区', '350200');
INSERT INTO `region` VALUES ('350301', '市辖区', '350300');
INSERT INTO `region` VALUES ('350302', '城厢区', '350300');
INSERT INTO `region` VALUES ('350303', '涵江区', '350300');
INSERT INTO `region` VALUES ('350304', '荔城区', '350300');
INSERT INTO `region` VALUES ('350305', '秀屿区', '350300');
INSERT INTO `region` VALUES ('350322', '仙游县', '350300');
INSERT INTO `region` VALUES ('350401', '市辖区', '350400');
INSERT INTO `region` VALUES ('350402', '梅列区', '350400');
INSERT INTO `region` VALUES ('350403', '三元区', '350400');
INSERT INTO `region` VALUES ('350421', '明溪县', '350400');
INSERT INTO `region` VALUES ('350423', '清流县', '350400');
INSERT INTO `region` VALUES ('350424', '宁化县', '350400');
INSERT INTO `region` VALUES ('350425', '大田县', '350400');
INSERT INTO `region` VALUES ('350426', '尤溪县', '350400');
INSERT INTO `region` VALUES ('350427', '沙　县', '350400');
INSERT INTO `region` VALUES ('350428', '将乐县', '350400');
INSERT INTO `region` VALUES ('350429', '泰宁县', '350400');
INSERT INTO `region` VALUES ('350430', '建宁县', '350400');
INSERT INTO `region` VALUES ('350481', '永安市', '350400');
INSERT INTO `region` VALUES ('350501', '市辖区', '350500');
INSERT INTO `region` VALUES ('350502', '鲤城区', '350500');
INSERT INTO `region` VALUES ('350503', '丰泽区', '350500');
INSERT INTO `region` VALUES ('350504', '洛江区', '350500');
INSERT INTO `region` VALUES ('350505', '泉港区', '350500');
INSERT INTO `region` VALUES ('350521', '惠安县', '350500');
INSERT INTO `region` VALUES ('350524', '安溪县', '350500');
INSERT INTO `region` VALUES ('350525', '永春县', '350500');
INSERT INTO `region` VALUES ('350526', '德化县', '350500');
INSERT INTO `region` VALUES ('350527', '金门县', '350500');
INSERT INTO `region` VALUES ('350581', '石狮市', '350500');
INSERT INTO `region` VALUES ('350582', '晋江市', '350500');
INSERT INTO `region` VALUES ('350583', '南安市', '350500');
INSERT INTO `region` VALUES ('350601', '市辖区', '350600');
INSERT INTO `region` VALUES ('350602', '芗城区', '350600');
INSERT INTO `region` VALUES ('350603', '龙文区', '350600');
INSERT INTO `region` VALUES ('350622', '云霄县', '350600');
INSERT INTO `region` VALUES ('350623', '漳浦县', '350600');
INSERT INTO `region` VALUES ('350624', '诏安县', '350600');
INSERT INTO `region` VALUES ('350625', '长泰县', '350600');
INSERT INTO `region` VALUES ('350626', '东山县', '350600');
INSERT INTO `region` VALUES ('350627', '南靖县', '350600');
INSERT INTO `region` VALUES ('350628', '平和县', '350600');
INSERT INTO `region` VALUES ('350629', '华安县', '350600');
INSERT INTO `region` VALUES ('350681', '龙海市', '350600');
INSERT INTO `region` VALUES ('350701', '市辖区', '350700');
INSERT INTO `region` VALUES ('350702', '延平区', '350700');
INSERT INTO `region` VALUES ('350721', '顺昌县', '350700');
INSERT INTO `region` VALUES ('350722', '浦城县', '350700');
INSERT INTO `region` VALUES ('350723', '光泽县', '350700');
INSERT INTO `region` VALUES ('350724', '松溪县', '350700');
INSERT INTO `region` VALUES ('350725', '政和县', '350700');
INSERT INTO `region` VALUES ('350781', '邵武市', '350700');
INSERT INTO `region` VALUES ('350782', '武夷山市', '350700');
INSERT INTO `region` VALUES ('350783', '建瓯市', '350700');
INSERT INTO `region` VALUES ('350784', '建阳市', '350700');
INSERT INTO `region` VALUES ('350801', '市辖区', '350800');
INSERT INTO `region` VALUES ('350802', '新罗区', '350800');
INSERT INTO `region` VALUES ('350821', '长汀县', '350800');
INSERT INTO `region` VALUES ('350822', '永定县', '350800');
INSERT INTO `region` VALUES ('350823', '上杭县', '350800');
INSERT INTO `region` VALUES ('350824', '武平县', '350800');
INSERT INTO `region` VALUES ('350825', '连城县', '350800');
INSERT INTO `region` VALUES ('350881', '漳平市', '350800');
INSERT INTO `region` VALUES ('350901', '市辖区', '350900');
INSERT INTO `region` VALUES ('350902', '蕉城区', '350900');
INSERT INTO `region` VALUES ('350921', '霞浦县', '350900');
INSERT INTO `region` VALUES ('350922', '古田县', '350900');
INSERT INTO `region` VALUES ('350923', '屏南县', '350900');
INSERT INTO `region` VALUES ('350924', '寿宁县', '350900');
INSERT INTO `region` VALUES ('350925', '周宁县', '350900');
INSERT INTO `region` VALUES ('350926', '柘荣县', '350900');
INSERT INTO `region` VALUES ('350981', '福安市', '350900');
INSERT INTO `region` VALUES ('350982', '福鼎市', '350900');
INSERT INTO `region` VALUES ('360101', '市辖区', '360100');
INSERT INTO `region` VALUES ('360102', '东湖区', '360100');
INSERT INTO `region` VALUES ('360103', '西湖区', '360100');
INSERT INTO `region` VALUES ('360104', '青云谱区', '360100');
INSERT INTO `region` VALUES ('360105', '湾里区', '360100');
INSERT INTO `region` VALUES ('360111', '青山湖区', '360100');
INSERT INTO `region` VALUES ('360121', '南昌县', '360100');
INSERT INTO `region` VALUES ('360122', '新建县', '360100');
INSERT INTO `region` VALUES ('360123', '安义县', '360100');
INSERT INTO `region` VALUES ('360124', '进贤县', '360100');
INSERT INTO `region` VALUES ('360201', '市辖区', '360200');
INSERT INTO `region` VALUES ('360202', '昌江区', '360200');
INSERT INTO `region` VALUES ('360203', '珠山区', '360200');
INSERT INTO `region` VALUES ('360222', '浮梁县', '360200');
INSERT INTO `region` VALUES ('360281', '乐平市', '360200');
INSERT INTO `region` VALUES ('360301', '市辖区', '360300');
INSERT INTO `region` VALUES ('360302', '安源区', '360300');
INSERT INTO `region` VALUES ('360313', '湘东区', '360300');
INSERT INTO `region` VALUES ('360321', '莲花县', '360300');
INSERT INTO `region` VALUES ('360322', '上栗县', '360300');
INSERT INTO `region` VALUES ('360323', '芦溪县', '360300');
INSERT INTO `region` VALUES ('360401', '市辖区', '360400');
INSERT INTO `region` VALUES ('360402', '庐山区', '360400');
INSERT INTO `region` VALUES ('360403', '浔阳区', '360400');
INSERT INTO `region` VALUES ('360421', '九江县', '360400');
INSERT INTO `region` VALUES ('360423', '武宁县', '360400');
INSERT INTO `region` VALUES ('360424', '修水县', '360400');
INSERT INTO `region` VALUES ('360425', '永修县', '360400');
INSERT INTO `region` VALUES ('360426', '德安县', '360400');
INSERT INTO `region` VALUES ('360427', '星子县', '360400');
INSERT INTO `region` VALUES ('360428', '都昌县', '360400');
INSERT INTO `region` VALUES ('360429', '湖口县', '360400');
INSERT INTO `region` VALUES ('360430', '彭泽县', '360400');
INSERT INTO `region` VALUES ('360481', '瑞昌市', '360400');
INSERT INTO `region` VALUES ('360501', '市辖区', '360500');
INSERT INTO `region` VALUES ('360502', '渝水区', '360500');
INSERT INTO `region` VALUES ('360521', '分宜县', '360500');
INSERT INTO `region` VALUES ('360601', '市辖区', '360600');
INSERT INTO `region` VALUES ('360602', '月湖区', '360600');
INSERT INTO `region` VALUES ('360622', '余江县', '360600');
INSERT INTO `region` VALUES ('360681', '贵溪市', '360600');
INSERT INTO `region` VALUES ('360701', '市辖区', '360700');
INSERT INTO `region` VALUES ('360702', '章贡区', '360700');
INSERT INTO `region` VALUES ('360721', '赣　县', '360700');
INSERT INTO `region` VALUES ('360722', '信丰县', '360700');
INSERT INTO `region` VALUES ('360723', '大余县', '360700');
INSERT INTO `region` VALUES ('360724', '上犹县', '360700');
INSERT INTO `region` VALUES ('360725', '崇义县', '360700');
INSERT INTO `region` VALUES ('360726', '安远县', '360700');
INSERT INTO `region` VALUES ('360727', '龙南县', '360700');
INSERT INTO `region` VALUES ('360728', '定南县', '360700');
INSERT INTO `region` VALUES ('360729', '全南县', '360700');
INSERT INTO `region` VALUES ('360730', '宁都县', '360700');
INSERT INTO `region` VALUES ('360731', '于都县', '360700');
INSERT INTO `region` VALUES ('360732', '兴国县', '360700');
INSERT INTO `region` VALUES ('360733', '会昌县', '360700');
INSERT INTO `region` VALUES ('360734', '寻乌县', '360700');
INSERT INTO `region` VALUES ('360735', '石城县', '360700');
INSERT INTO `region` VALUES ('360781', '瑞金市', '360700');
INSERT INTO `region` VALUES ('360782', '南康市', '360700');
INSERT INTO `region` VALUES ('360801', '市辖区', '360800');
INSERT INTO `region` VALUES ('360802', '吉州区', '360800');
INSERT INTO `region` VALUES ('360803', '青原区', '360800');
INSERT INTO `region` VALUES ('360821', '吉安县', '360800');
INSERT INTO `region` VALUES ('360822', '吉水县', '360800');
INSERT INTO `region` VALUES ('360823', '峡江县', '360800');
INSERT INTO `region` VALUES ('360824', '新干县', '360800');
INSERT INTO `region` VALUES ('360825', '永丰县', '360800');
INSERT INTO `region` VALUES ('360826', '泰和县', '360800');
INSERT INTO `region` VALUES ('360827', '遂川县', '360800');
INSERT INTO `region` VALUES ('360828', '万安县', '360800');
INSERT INTO `region` VALUES ('360829', '安福县', '360800');
INSERT INTO `region` VALUES ('360830', '永新县', '360800');
INSERT INTO `region` VALUES ('360881', '井冈山市', '360800');
INSERT INTO `region` VALUES ('360901', '市辖区', '360900');
INSERT INTO `region` VALUES ('360902', '袁州区', '360900');
INSERT INTO `region` VALUES ('360921', '奉新县', '360900');
INSERT INTO `region` VALUES ('360922', '万载县', '360900');
INSERT INTO `region` VALUES ('360923', '上高县', '360900');
INSERT INTO `region` VALUES ('360924', '宜丰县', '360900');
INSERT INTO `region` VALUES ('360925', '靖安县', '360900');
INSERT INTO `region` VALUES ('360926', '铜鼓县', '360900');
INSERT INTO `region` VALUES ('360981', '丰城市', '360900');
INSERT INTO `region` VALUES ('360982', '樟树市', '360900');
INSERT INTO `region` VALUES ('360983', '高安市', '360900');
INSERT INTO `region` VALUES ('361001', '市辖区', '361000');
INSERT INTO `region` VALUES ('361002', '临川区', '361000');
INSERT INTO `region` VALUES ('361021', '南城县', '361000');
INSERT INTO `region` VALUES ('361022', '黎川县', '361000');
INSERT INTO `region` VALUES ('361023', '南丰县', '361000');
INSERT INTO `region` VALUES ('361024', '崇仁县', '361000');
INSERT INTO `region` VALUES ('361025', '乐安县', '361000');
INSERT INTO `region` VALUES ('361026', '宜黄县', '361000');
INSERT INTO `region` VALUES ('361027', '金溪县', '361000');
INSERT INTO `region` VALUES ('361028', '资溪县', '361000');
INSERT INTO `region` VALUES ('361029', '东乡县', '361000');
INSERT INTO `region` VALUES ('361030', '广昌县', '361000');
INSERT INTO `region` VALUES ('361101', '市辖区', '361100');
INSERT INTO `region` VALUES ('361102', '信州区', '361100');
INSERT INTO `region` VALUES ('361121', '上饶县', '361100');
INSERT INTO `region` VALUES ('361122', '广丰县', '361100');
INSERT INTO `region` VALUES ('361123', '玉山县', '361100');
INSERT INTO `region` VALUES ('361124', '铅山县', '361100');
INSERT INTO `region` VALUES ('361125', '横峰县', '361100');
INSERT INTO `region` VALUES ('361126', '弋阳县', '361100');
INSERT INTO `region` VALUES ('361127', '余干县', '361100');
INSERT INTO `region` VALUES ('361128', '鄱阳县', '361100');
INSERT INTO `region` VALUES ('361129', '万年县', '361100');
INSERT INTO `region` VALUES ('361130', '婺源县', '361100');
INSERT INTO `region` VALUES ('361181', '德兴市', '361100');
INSERT INTO `region` VALUES ('370101', '市辖区', '370100');
INSERT INTO `region` VALUES ('370102', '历下区', '370100');
INSERT INTO `region` VALUES ('370103', '市中区', '370100');
INSERT INTO `region` VALUES ('370104', '槐荫区', '370100');
INSERT INTO `region` VALUES ('370105', '天桥区', '370100');
INSERT INTO `region` VALUES ('370112', '历城区', '370100');
INSERT INTO `region` VALUES ('370113', '长清区', '370100');
INSERT INTO `region` VALUES ('370124', '平阴县', '370100');
INSERT INTO `region` VALUES ('370125', '济阳县', '370100');
INSERT INTO `region` VALUES ('370126', '商河县', '370100');
INSERT INTO `region` VALUES ('370181', '章丘市', '370100');
INSERT INTO `region` VALUES ('370201', '市辖区', '370200');
INSERT INTO `region` VALUES ('370202', '市南区', '370200');
INSERT INTO `region` VALUES ('370203', '市北区', '370200');
INSERT INTO `region` VALUES ('370205', '四方区', '370200');
INSERT INTO `region` VALUES ('370211', '黄岛区', '370200');
INSERT INTO `region` VALUES ('370212', '崂山区', '370200');
INSERT INTO `region` VALUES ('370213', '李沧区', '370200');
INSERT INTO `region` VALUES ('370214', '城阳区', '370200');
INSERT INTO `region` VALUES ('370281', '胶州市', '370200');
INSERT INTO `region` VALUES ('370282', '即墨市', '370200');
INSERT INTO `region` VALUES ('370283', '平度市', '370200');
INSERT INTO `region` VALUES ('370284', '胶南市', '370200');
INSERT INTO `region` VALUES ('370285', '莱西市', '370200');
INSERT INTO `region` VALUES ('370301', '市辖区', '370300');
INSERT INTO `region` VALUES ('370302', '淄川区', '370300');
INSERT INTO `region` VALUES ('370303', '张店区', '370300');
INSERT INTO `region` VALUES ('370304', '博山区', '370300');
INSERT INTO `region` VALUES ('370305', '临淄区', '370300');
INSERT INTO `region` VALUES ('370306', '周村区', '370300');
INSERT INTO `region` VALUES ('370321', '桓台县', '370300');
INSERT INTO `region` VALUES ('370322', '高青县', '370300');
INSERT INTO `region` VALUES ('370323', '沂源县', '370300');
INSERT INTO `region` VALUES ('370401', '市辖区', '370400');
INSERT INTO `region` VALUES ('370402', '市中区', '370400');
INSERT INTO `region` VALUES ('370403', '薛城区', '370400');
INSERT INTO `region` VALUES ('370404', '峄城区', '370400');
INSERT INTO `region` VALUES ('370405', '台儿庄区', '370400');
INSERT INTO `region` VALUES ('370406', '山亭区', '370400');
INSERT INTO `region` VALUES ('370481', '滕州市', '370400');
INSERT INTO `region` VALUES ('370501', '市辖区', '370500');
INSERT INTO `region` VALUES ('370502', '东营区', '370500');
INSERT INTO `region` VALUES ('370503', '河口区', '370500');
INSERT INTO `region` VALUES ('370521', '垦利县', '370500');
INSERT INTO `region` VALUES ('370522', '利津县', '370500');
INSERT INTO `region` VALUES ('370523', '广饶县', '370500');
INSERT INTO `region` VALUES ('370601', '市辖区', '370600');
INSERT INTO `region` VALUES ('370602', '芝罘区', '370600');
INSERT INTO `region` VALUES ('370611', '福山区', '370600');
INSERT INTO `region` VALUES ('370612', '牟平区', '370600');
INSERT INTO `region` VALUES ('370613', '莱山区', '370600');
INSERT INTO `region` VALUES ('370634', '长岛县', '370600');
INSERT INTO `region` VALUES ('370681', '龙口市', '370600');
INSERT INTO `region` VALUES ('370682', '莱阳市', '370600');
INSERT INTO `region` VALUES ('370683', '莱州市', '370600');
INSERT INTO `region` VALUES ('370684', '蓬莱市', '370600');
INSERT INTO `region` VALUES ('370685', '招远市', '370600');
INSERT INTO `region` VALUES ('370686', '栖霞市', '370600');
INSERT INTO `region` VALUES ('370687', '海阳市', '370600');
INSERT INTO `region` VALUES ('370701', '市辖区', '370700');
INSERT INTO `region` VALUES ('370702', '潍城区', '370700');
INSERT INTO `region` VALUES ('370703', '寒亭区', '370700');
INSERT INTO `region` VALUES ('370704', '坊子区', '370700');
INSERT INTO `region` VALUES ('370705', '奎文区', '370700');
INSERT INTO `region` VALUES ('370724', '临朐县', '370700');
INSERT INTO `region` VALUES ('370725', '昌乐县', '370700');
INSERT INTO `region` VALUES ('370781', '青州市', '370700');
INSERT INTO `region` VALUES ('370782', '诸城市', '370700');
INSERT INTO `region` VALUES ('370783', '寿光市', '370700');
INSERT INTO `region` VALUES ('370784', '安丘市', '370700');
INSERT INTO `region` VALUES ('370785', '高密市', '370700');
INSERT INTO `region` VALUES ('370786', '昌邑市', '370700');
INSERT INTO `region` VALUES ('370801', '市辖区', '370800');
INSERT INTO `region` VALUES ('370802', '市中区', '370800');
INSERT INTO `region` VALUES ('370811', '任城区', '370800');
INSERT INTO `region` VALUES ('370826', '微山县', '370800');
INSERT INTO `region` VALUES ('370827', '鱼台县', '370800');
INSERT INTO `region` VALUES ('370828', '金乡县', '370800');
INSERT INTO `region` VALUES ('370829', '嘉祥县', '370800');
INSERT INTO `region` VALUES ('370830', '汶上县', '370800');
INSERT INTO `region` VALUES ('370831', '泗水县', '370800');
INSERT INTO `region` VALUES ('370832', '梁山县', '370800');
INSERT INTO `region` VALUES ('370881', '曲阜市', '370800');
INSERT INTO `region` VALUES ('370882', '兖州市', '370800');
INSERT INTO `region` VALUES ('370883', '邹城市', '370800');
INSERT INTO `region` VALUES ('370901', '市辖区', '370900');
INSERT INTO `region` VALUES ('370902', '泰山区', '370900');
INSERT INTO `region` VALUES ('370903', '岱岳区', '370900');
INSERT INTO `region` VALUES ('370921', '宁阳县', '370900');
INSERT INTO `region` VALUES ('370923', '东平县', '370900');
INSERT INTO `region` VALUES ('370982', '新泰市', '370900');
INSERT INTO `region` VALUES ('370983', '肥城市', '370900');
INSERT INTO `region` VALUES ('371001', '市辖区', '371000');
INSERT INTO `region` VALUES ('371002', '环翠区', '371000');
INSERT INTO `region` VALUES ('371081', '文登市', '371000');
INSERT INTO `region` VALUES ('371082', '荣成市', '371000');
INSERT INTO `region` VALUES ('371083', '乳山市', '371000');
INSERT INTO `region` VALUES ('371101', '市辖区', '371100');
INSERT INTO `region` VALUES ('371102', '东港区', '371100');
INSERT INTO `region` VALUES ('371103', '岚山区', '371100');
INSERT INTO `region` VALUES ('371121', '五莲县', '371100');
INSERT INTO `region` VALUES ('371122', '莒　县', '371100');
INSERT INTO `region` VALUES ('371201', '市辖区', '371200');
INSERT INTO `region` VALUES ('371202', '莱城区', '371200');
INSERT INTO `region` VALUES ('371203', '钢城区', '371200');
INSERT INTO `region` VALUES ('371301', '市辖区', '371300');
INSERT INTO `region` VALUES ('371302', '兰山区', '371300');
INSERT INTO `region` VALUES ('371311', '罗庄区', '371300');
INSERT INTO `region` VALUES ('371312', '河东区', '371300');
INSERT INTO `region` VALUES ('371321', '沂南县', '371300');
INSERT INTO `region` VALUES ('371322', '郯城县', '371300');
INSERT INTO `region` VALUES ('371323', '沂水县', '371300');
INSERT INTO `region` VALUES ('371324', '苍山县', '371300');
INSERT INTO `region` VALUES ('371325', '费　县', '371300');
INSERT INTO `region` VALUES ('371326', '平邑县', '371300');
INSERT INTO `region` VALUES ('371327', '莒南县', '371300');
INSERT INTO `region` VALUES ('371328', '蒙阴县', '371300');
INSERT INTO `region` VALUES ('371329', '临沭县', '371300');
INSERT INTO `region` VALUES ('371401', '市辖区', '371400');
INSERT INTO `region` VALUES ('371402', '德城区', '371400');
INSERT INTO `region` VALUES ('371421', '陵　县', '371400');
INSERT INTO `region` VALUES ('371422', '宁津县', '371400');
INSERT INTO `region` VALUES ('371423', '庆云县', '371400');
INSERT INTO `region` VALUES ('371424', '临邑县', '371400');
INSERT INTO `region` VALUES ('371425', '齐河县', '371400');
INSERT INTO `region` VALUES ('371426', '平原县', '371400');
INSERT INTO `region` VALUES ('371427', '夏津县', '371400');
INSERT INTO `region` VALUES ('371428', '武城县', '371400');
INSERT INTO `region` VALUES ('371481', '乐陵市', '371400');
INSERT INTO `region` VALUES ('371482', '禹城市', '371400');
INSERT INTO `region` VALUES ('371501', '市辖区', '371500');
INSERT INTO `region` VALUES ('371502', '东昌府区', '371500');
INSERT INTO `region` VALUES ('371521', '阳谷县', '371500');
INSERT INTO `region` VALUES ('371522', '莘　县', '371500');
INSERT INTO `region` VALUES ('371523', '茌平县', '371500');
INSERT INTO `region` VALUES ('371524', '东阿县', '371500');
INSERT INTO `region` VALUES ('371525', '冠　县', '371500');
INSERT INTO `region` VALUES ('371526', '高唐县', '371500');
INSERT INTO `region` VALUES ('371581', '临清市', '371500');
INSERT INTO `region` VALUES ('371601', '市辖区', '371600');
INSERT INTO `region` VALUES ('371602', '滨城区', '371600');
INSERT INTO `region` VALUES ('371621', '惠民县', '371600');
INSERT INTO `region` VALUES ('371622', '阳信县', '371600');
INSERT INTO `region` VALUES ('371623', '无棣县', '371600');
INSERT INTO `region` VALUES ('371624', '沾化县', '371600');
INSERT INTO `region` VALUES ('371625', '博兴县', '371600');
INSERT INTO `region` VALUES ('371626', '邹平县', '371600');
INSERT INTO `region` VALUES ('371701', '市辖区', '371700');
INSERT INTO `region` VALUES ('371702', '牡丹区', '371700');
INSERT INTO `region` VALUES ('371721', '曹　县', '371700');
INSERT INTO `region` VALUES ('371722', '单　县', '371700');
INSERT INTO `region` VALUES ('371723', '成武县', '371700');
INSERT INTO `region` VALUES ('371724', '巨野县', '371700');
INSERT INTO `region` VALUES ('371725', '郓城县', '371700');
INSERT INTO `region` VALUES ('371726', '鄄城县', '371700');
INSERT INTO `region` VALUES ('371727', '定陶县', '371700');
INSERT INTO `region` VALUES ('371728', '东明县', '371700');
INSERT INTO `region` VALUES ('410101', '市辖区', '410100');
INSERT INTO `region` VALUES ('410102', '中原区', '410100');
INSERT INTO `region` VALUES ('410103', '二七区', '410100');
INSERT INTO `region` VALUES ('410104', '管城回族区', '410100');
INSERT INTO `region` VALUES ('410105', '金水区', '410100');
INSERT INTO `region` VALUES ('410106', '上街区', '410100');
INSERT INTO `region` VALUES ('410108', '邙山区', '410100');
INSERT INTO `region` VALUES ('410122', '中牟县', '410100');
INSERT INTO `region` VALUES ('410181', '巩义市', '410100');
INSERT INTO `region` VALUES ('410182', '荥阳市', '410100');
INSERT INTO `region` VALUES ('410183', '新密市', '410100');
INSERT INTO `region` VALUES ('410184', '新郑市', '410100');
INSERT INTO `region` VALUES ('410185', '登封市', '410100');
INSERT INTO `region` VALUES ('410201', '市辖区', '410200');
INSERT INTO `region` VALUES ('410202', '龙亭区', '410200');
INSERT INTO `region` VALUES ('410203', '顺河回族区', '410200');
INSERT INTO `region` VALUES ('410204', '鼓楼区', '410200');
INSERT INTO `region` VALUES ('410205', '南关区', '410200');
INSERT INTO `region` VALUES ('410211', '郊　区', '410200');
INSERT INTO `region` VALUES ('410221', '杞　县', '410200');
INSERT INTO `region` VALUES ('410222', '通许县', '410200');
INSERT INTO `region` VALUES ('410223', '尉氏县', '410200');
INSERT INTO `region` VALUES ('410224', '开封县', '410200');
INSERT INTO `region` VALUES ('410225', '兰考县', '410200');
INSERT INTO `region` VALUES ('410301', '市辖区', '410300');
INSERT INTO `region` VALUES ('410302', '老城区', '410300');
INSERT INTO `region` VALUES ('410303', '西工区', '410300');
INSERT INTO `region` VALUES ('410304', '廛河回族区', '410300');
INSERT INTO `region` VALUES ('410305', '涧西区', '410300');
INSERT INTO `region` VALUES ('410306', '吉利区', '410300');
INSERT INTO `region` VALUES ('410307', '洛龙区', '410300');
INSERT INTO `region` VALUES ('410322', '孟津县', '410300');
INSERT INTO `region` VALUES ('410323', '新安县', '410300');
INSERT INTO `region` VALUES ('410324', '栾川县', '410300');
INSERT INTO `region` VALUES ('410325', '嵩　县', '410300');
INSERT INTO `region` VALUES ('410326', '汝阳县', '410300');
INSERT INTO `region` VALUES ('410327', '宜阳县', '410300');
INSERT INTO `region` VALUES ('410328', '洛宁县', '410300');
INSERT INTO `region` VALUES ('410329', '伊川县', '410300');
INSERT INTO `region` VALUES ('410381', '偃师市', '410300');
INSERT INTO `region` VALUES ('410401', '市辖区', '410400');
INSERT INTO `region` VALUES ('410402', '新华区', '410400');
INSERT INTO `region` VALUES ('410403', '卫东区', '410400');
INSERT INTO `region` VALUES ('410404', '石龙区', '410400');
INSERT INTO `region` VALUES ('410411', '湛河区', '410400');
INSERT INTO `region` VALUES ('410421', '宝丰县', '410400');
INSERT INTO `region` VALUES ('410422', '叶　县', '410400');
INSERT INTO `region` VALUES ('410423', '鲁山县', '410400');
INSERT INTO `region` VALUES ('410425', '郏　县', '410400');
INSERT INTO `region` VALUES ('410481', '舞钢市', '410400');
INSERT INTO `region` VALUES ('410482', '汝州市', '410400');
INSERT INTO `region` VALUES ('410501', '市辖区', '410500');
INSERT INTO `region` VALUES ('410502', '文峰区', '410500');
INSERT INTO `region` VALUES ('410503', '北关区', '410500');
INSERT INTO `region` VALUES ('410505', '殷都区', '410500');
INSERT INTO `region` VALUES ('410506', '龙安区', '410500');
INSERT INTO `region` VALUES ('410522', '安阳县', '410500');
INSERT INTO `region` VALUES ('410523', '汤阴县', '410500');
INSERT INTO `region` VALUES ('410526', '滑　县', '410500');
INSERT INTO `region` VALUES ('410527', '内黄县', '410500');
INSERT INTO `region` VALUES ('410581', '林州市', '410500');
INSERT INTO `region` VALUES ('410601', '市辖区', '410600');
INSERT INTO `region` VALUES ('410602', '鹤山区', '410600');
INSERT INTO `region` VALUES ('410603', '山城区', '410600');
INSERT INTO `region` VALUES ('410611', '淇滨区', '410600');
INSERT INTO `region` VALUES ('410621', '浚　县', '410600');
INSERT INTO `region` VALUES ('410622', '淇　县', '410600');
INSERT INTO `region` VALUES ('410701', '市辖区', '410700');
INSERT INTO `region` VALUES ('410702', '红旗区', '410700');
INSERT INTO `region` VALUES ('410703', '卫滨区', '410700');
INSERT INTO `region` VALUES ('410704', '凤泉区', '410700');
INSERT INTO `region` VALUES ('410711', '牧野区', '410700');
INSERT INTO `region` VALUES ('410721', '新乡县', '410700');
INSERT INTO `region` VALUES ('410724', '获嘉县', '410700');
INSERT INTO `region` VALUES ('410725', '原阳县', '410700');
INSERT INTO `region` VALUES ('410726', '延津县', '410700');
INSERT INTO `region` VALUES ('410727', '封丘县', '410700');
INSERT INTO `region` VALUES ('410728', '长垣县', '410700');
INSERT INTO `region` VALUES ('410781', '卫辉市', '410700');
INSERT INTO `region` VALUES ('410782', '辉县市', '410700');
INSERT INTO `region` VALUES ('410801', '市辖区', '410800');
INSERT INTO `region` VALUES ('410802', '解放区', '410800');
INSERT INTO `region` VALUES ('410803', '中站区', '410800');
INSERT INTO `region` VALUES ('410804', '马村区', '410800');
INSERT INTO `region` VALUES ('410811', '山阳区', '410800');
INSERT INTO `region` VALUES ('410821', '修武县', '410800');
INSERT INTO `region` VALUES ('410822', '博爱县', '410800');
INSERT INTO `region` VALUES ('410823', '武陟县', '410800');
INSERT INTO `region` VALUES ('410825', '温　县', '410800');
INSERT INTO `region` VALUES ('410881', '济源市', '410800');
INSERT INTO `region` VALUES ('410882', '沁阳市', '410800');
INSERT INTO `region` VALUES ('410883', '孟州市', '410800');
INSERT INTO `region` VALUES ('410901', '市辖区', '410900');
INSERT INTO `region` VALUES ('410902', '华龙区', '410900');
INSERT INTO `region` VALUES ('410922', '清丰县', '410900');
INSERT INTO `region` VALUES ('410923', '南乐县', '410900');
INSERT INTO `region` VALUES ('410926', '范　县', '410900');
INSERT INTO `region` VALUES ('410927', '台前县', '410900');
INSERT INTO `region` VALUES ('410928', '濮阳县', '410900');
INSERT INTO `region` VALUES ('411001', '市辖区', '411000');
INSERT INTO `region` VALUES ('411002', '魏都区', '411000');
INSERT INTO `region` VALUES ('411023', '许昌县', '411000');
INSERT INTO `region` VALUES ('411024', '鄢陵县', '411000');
INSERT INTO `region` VALUES ('411025', '襄城县', '411000');
INSERT INTO `region` VALUES ('411081', '禹州市', '411000');
INSERT INTO `region` VALUES ('411082', '长葛市', '411000');
INSERT INTO `region` VALUES ('411101', '市辖区', '411100');
INSERT INTO `region` VALUES ('411102', '源汇区', '411100');
INSERT INTO `region` VALUES ('411103', '郾城区', '411100');
INSERT INTO `region` VALUES ('411104', '召陵区', '411100');
INSERT INTO `region` VALUES ('411121', '舞阳县', '411100');
INSERT INTO `region` VALUES ('411122', '临颍县', '411100');
INSERT INTO `region` VALUES ('411201', '市辖区', '411200');
INSERT INTO `region` VALUES ('411202', '湖滨区', '411200');
INSERT INTO `region` VALUES ('411221', '渑池县', '411200');
INSERT INTO `region` VALUES ('411222', '陕　县', '411200');
INSERT INTO `region` VALUES ('411224', '卢氏县', '411200');
INSERT INTO `region` VALUES ('411281', '义马市', '411200');
INSERT INTO `region` VALUES ('411282', '灵宝市', '411200');
INSERT INTO `region` VALUES ('411301', '市辖区', '411300');
INSERT INTO `region` VALUES ('411302', '宛城区', '411300');
INSERT INTO `region` VALUES ('411303', '卧龙区', '411300');
INSERT INTO `region` VALUES ('411321', '南召县', '411300');
INSERT INTO `region` VALUES ('411322', '方城县', '411300');
INSERT INTO `region` VALUES ('411323', '西峡县', '411300');
INSERT INTO `region` VALUES ('411324', '镇平县', '411300');
INSERT INTO `region` VALUES ('411325', '内乡县', '411300');
INSERT INTO `region` VALUES ('411326', '淅川县', '411300');
INSERT INTO `region` VALUES ('411327', '社旗县', '411300');
INSERT INTO `region` VALUES ('411328', '唐河县', '411300');
INSERT INTO `region` VALUES ('411329', '新野县', '411300');
INSERT INTO `region` VALUES ('411330', '桐柏县', '411300');
INSERT INTO `region` VALUES ('411381', '邓州市', '411300');
INSERT INTO `region` VALUES ('411401', '市辖区', '411400');
INSERT INTO `region` VALUES ('411402', '梁园区', '411400');
INSERT INTO `region` VALUES ('411403', '睢阳区', '411400');
INSERT INTO `region` VALUES ('411421', '民权县', '411400');
INSERT INTO `region` VALUES ('411422', '睢　县', '411400');
INSERT INTO `region` VALUES ('411423', '宁陵县', '411400');
INSERT INTO `region` VALUES ('411424', '柘城县', '411400');
INSERT INTO `region` VALUES ('411425', '虞城县', '411400');
INSERT INTO `region` VALUES ('411426', '夏邑县', '411400');
INSERT INTO `region` VALUES ('411481', '永城市', '411400');
INSERT INTO `region` VALUES ('411501', '市辖区', '411500');
INSERT INTO `region` VALUES ('411502', '师河区', '411500');
INSERT INTO `region` VALUES ('411503', '平桥区', '411500');
INSERT INTO `region` VALUES ('411521', '罗山县', '411500');
INSERT INTO `region` VALUES ('411522', '光山县', '411500');
INSERT INTO `region` VALUES ('411523', '新　县', '411500');
INSERT INTO `region` VALUES ('411524', '商城县', '411500');
INSERT INTO `region` VALUES ('411525', '固始县', '411500');
INSERT INTO `region` VALUES ('411526', '潢川县', '411500');
INSERT INTO `region` VALUES ('411527', '淮滨县', '411500');
INSERT INTO `region` VALUES ('411528', '息　县', '411500');
INSERT INTO `region` VALUES ('411601', '市辖区', '411600');
INSERT INTO `region` VALUES ('411602', '川汇区', '411600');
INSERT INTO `region` VALUES ('411621', '扶沟县', '411600');
INSERT INTO `region` VALUES ('411622', '西华县', '411600');
INSERT INTO `region` VALUES ('411623', '商水县', '411600');
INSERT INTO `region` VALUES ('411624', '沈丘县', '411600');
INSERT INTO `region` VALUES ('411625', '郸城县', '411600');
INSERT INTO `region` VALUES ('411626', '淮阳县', '411600');
INSERT INTO `region` VALUES ('411627', '太康县', '411600');
INSERT INTO `region` VALUES ('411628', '鹿邑县', '411600');
INSERT INTO `region` VALUES ('411681', '项城市', '411600');
INSERT INTO `region` VALUES ('411701', '市辖区', '411700');
INSERT INTO `region` VALUES ('411702', '驿城区', '411700');
INSERT INTO `region` VALUES ('411721', '西平县', '411700');
INSERT INTO `region` VALUES ('411722', '上蔡县', '411700');
INSERT INTO `region` VALUES ('411723', '平舆县', '411700');
INSERT INTO `region` VALUES ('411724', '正阳县', '411700');
INSERT INTO `region` VALUES ('411725', '确山县', '411700');
INSERT INTO `region` VALUES ('411726', '泌阳县', '411700');
INSERT INTO `region` VALUES ('411727', '汝南县', '411700');
INSERT INTO `region` VALUES ('411728', '遂平县', '411700');
INSERT INTO `region` VALUES ('411729', '新蔡县', '411700');
INSERT INTO `region` VALUES ('420101', '市辖区', '420100');
INSERT INTO `region` VALUES ('420102', '江岸区', '420100');
INSERT INTO `region` VALUES ('420103', '江汉区', '420100');
INSERT INTO `region` VALUES ('420104', '乔口区', '420100');
INSERT INTO `region` VALUES ('420105', '汉阳区', '420100');
INSERT INTO `region` VALUES ('420106', '武昌区', '420100');
INSERT INTO `region` VALUES ('420107', '青山区', '420100');
INSERT INTO `region` VALUES ('420111', '洪山区', '420100');
INSERT INTO `region` VALUES ('420112', '东西湖区', '420100');
INSERT INTO `region` VALUES ('420113', '汉南区', '420100');
INSERT INTO `region` VALUES ('420114', '蔡甸区', '420100');
INSERT INTO `region` VALUES ('420115', '江夏区', '420100');
INSERT INTO `region` VALUES ('420116', '黄陂区', '420100');
INSERT INTO `region` VALUES ('420117', '新洲区', '420100');
INSERT INTO `region` VALUES ('420201', '市辖区', '420200');
INSERT INTO `region` VALUES ('420202', '黄石港区', '420200');
INSERT INTO `region` VALUES ('420203', '西塞山区', '420200');
INSERT INTO `region` VALUES ('420204', '下陆区', '420200');
INSERT INTO `region` VALUES ('420205', '铁山区', '420200');
INSERT INTO `region` VALUES ('420222', '阳新县', '420200');
INSERT INTO `region` VALUES ('420281', '大冶市', '420200');
INSERT INTO `region` VALUES ('420301', '市辖区', '420300');
INSERT INTO `region` VALUES ('420302', '茅箭区', '420300');
INSERT INTO `region` VALUES ('420303', '张湾区', '420300');
INSERT INTO `region` VALUES ('420321', '郧　县', '420300');
INSERT INTO `region` VALUES ('420322', '郧西县', '420300');
INSERT INTO `region` VALUES ('420323', '竹山县', '420300');
INSERT INTO `region` VALUES ('420324', '竹溪县', '420300');
INSERT INTO `region` VALUES ('420325', '房　县', '420300');
INSERT INTO `region` VALUES ('420381', '丹江口市', '420300');
INSERT INTO `region` VALUES ('420501', '市辖区', '420500');
INSERT INTO `region` VALUES ('420502', '西陵区', '420500');
INSERT INTO `region` VALUES ('420503', '伍家岗区', '420500');
INSERT INTO `region` VALUES ('420504', '点军区', '420500');
INSERT INTO `region` VALUES ('420505', '猇亭区', '420500');
INSERT INTO `region` VALUES ('420506', '夷陵区', '420500');
INSERT INTO `region` VALUES ('420525', '远安县', '420500');
INSERT INTO `region` VALUES ('420526', '兴山县', '420500');
INSERT INTO `region` VALUES ('420527', '秭归县', '420500');
INSERT INTO `region` VALUES ('420528', '长阳土家族自治县', '420500');
INSERT INTO `region` VALUES ('420529', '五峰土家族自治县', '420500');
INSERT INTO `region` VALUES ('420581', '宜都市', '420500');
INSERT INTO `region` VALUES ('420582', '当阳市', '420500');
INSERT INTO `region` VALUES ('420583', '枝江市', '420500');
INSERT INTO `region` VALUES ('420601', '市辖区', '420600');
INSERT INTO `region` VALUES ('420602', '襄城区', '420600');
INSERT INTO `region` VALUES ('420606', '樊城区', '420600');
INSERT INTO `region` VALUES ('420607', '襄阳区', '420600');
INSERT INTO `region` VALUES ('420624', '南漳县', '420600');
INSERT INTO `region` VALUES ('420625', '谷城县', '420600');
INSERT INTO `region` VALUES ('420626', '保康县', '420600');
INSERT INTO `region` VALUES ('420682', '老河口市', '420600');
INSERT INTO `region` VALUES ('420683', '枣阳市', '420600');
INSERT INTO `region` VALUES ('420684', '宜城市', '420600');
INSERT INTO `region` VALUES ('420701', '市辖区', '420700');
INSERT INTO `region` VALUES ('420702', '梁子湖区', '420700');
INSERT INTO `region` VALUES ('420703', '华容区', '420700');
INSERT INTO `region` VALUES ('420704', '鄂城区', '420700');
INSERT INTO `region` VALUES ('420801', '市辖区', '420800');
INSERT INTO `region` VALUES ('420802', '东宝区', '420800');
INSERT INTO `region` VALUES ('420804', '掇刀区', '420800');
INSERT INTO `region` VALUES ('420821', '京山县', '420800');
INSERT INTO `region` VALUES ('420822', '沙洋县', '420800');
INSERT INTO `region` VALUES ('420881', '钟祥市', '420800');
INSERT INTO `region` VALUES ('420901', '市辖区', '420900');
INSERT INTO `region` VALUES ('420902', '孝南区', '420900');
INSERT INTO `region` VALUES ('420921', '孝昌县', '420900');
INSERT INTO `region` VALUES ('420922', '大悟县', '420900');
INSERT INTO `region` VALUES ('420923', '云梦县', '420900');
INSERT INTO `region` VALUES ('420981', '应城市', '420900');
INSERT INTO `region` VALUES ('420982', '安陆市', '420900');
INSERT INTO `region` VALUES ('420984', '汉川市', '420900');
INSERT INTO `region` VALUES ('421001', '市辖区', '421000');
INSERT INTO `region` VALUES ('421002', '沙市区', '421000');
INSERT INTO `region` VALUES ('421003', '荆州区', '421000');
INSERT INTO `region` VALUES ('421022', '公安县', '421000');
INSERT INTO `region` VALUES ('421023', '监利县', '421000');
INSERT INTO `region` VALUES ('421024', '江陵县', '421000');
INSERT INTO `region` VALUES ('421081', '石首市', '421000');
INSERT INTO `region` VALUES ('421083', '洪湖市', '421000');
INSERT INTO `region` VALUES ('421087', '松滋市', '421000');
INSERT INTO `region` VALUES ('421101', '市辖区', '421100');
INSERT INTO `region` VALUES ('421102', '黄州区', '421100');
INSERT INTO `region` VALUES ('421121', '团风县', '421100');
INSERT INTO `region` VALUES ('421122', '红安县', '421100');
INSERT INTO `region` VALUES ('421123', '罗田县', '421100');
INSERT INTO `region` VALUES ('421124', '英山县', '421100');
INSERT INTO `region` VALUES ('421125', '浠水县', '421100');
INSERT INTO `region` VALUES ('421126', '蕲春县', '421100');
INSERT INTO `region` VALUES ('421127', '黄梅县', '421100');
INSERT INTO `region` VALUES ('421181', '麻城市', '421100');
INSERT INTO `region` VALUES ('421182', '武穴市', '421100');
INSERT INTO `region` VALUES ('421201', '市辖区', '421200');
INSERT INTO `region` VALUES ('421202', '咸安区', '421200');
INSERT INTO `region` VALUES ('421221', '嘉鱼县', '421200');
INSERT INTO `region` VALUES ('421222', '通城县', '421200');
INSERT INTO `region` VALUES ('421223', '崇阳县', '421200');
INSERT INTO `region` VALUES ('421224', '通山县', '421200');
INSERT INTO `region` VALUES ('421281', '赤壁市', '421200');
INSERT INTO `region` VALUES ('421301', '市辖区', '421300');
INSERT INTO `region` VALUES ('421302', '曾都区', '421300');
INSERT INTO `region` VALUES ('421381', '广水市', '421300');
INSERT INTO `region` VALUES ('422801', '恩施市', '422800');
INSERT INTO `region` VALUES ('422802', '利川市', '422800');
INSERT INTO `region` VALUES ('422822', '建始县', '422800');
INSERT INTO `region` VALUES ('422823', '巴东县', '422800');
INSERT INTO `region` VALUES ('422825', '宣恩县', '422800');
INSERT INTO `region` VALUES ('422826', '咸丰县', '422800');
INSERT INTO `region` VALUES ('422827', '来凤县', '422800');
INSERT INTO `region` VALUES ('422828', '鹤峰县', '422800');
INSERT INTO `region` VALUES ('429004', '仙桃市', '429000');
INSERT INTO `region` VALUES ('429005', '潜江市', '429000');
INSERT INTO `region` VALUES ('429006', '天门市', '429000');
INSERT INTO `region` VALUES ('429021', '神农架林区', '429000');
INSERT INTO `region` VALUES ('430101', '市辖区', '430100');
INSERT INTO `region` VALUES ('430102', '芙蓉区', '430100');
INSERT INTO `region` VALUES ('430103', '天心区', '430100');
INSERT INTO `region` VALUES ('430104', '岳麓区', '430100');
INSERT INTO `region` VALUES ('430105', '开福区', '430100');
INSERT INTO `region` VALUES ('430111', '雨花区', '430100');
INSERT INTO `region` VALUES ('430121', '长沙县', '430100');
INSERT INTO `region` VALUES ('430122', '望城县', '430100');
INSERT INTO `region` VALUES ('430124', '宁乡县', '430100');
INSERT INTO `region` VALUES ('430181', '浏阳市', '430100');
INSERT INTO `region` VALUES ('430201', '市辖区', '430200');
INSERT INTO `region` VALUES ('430202', '荷塘区', '430200');
INSERT INTO `region` VALUES ('430203', '芦淞区', '430200');
INSERT INTO `region` VALUES ('430204', '石峰区', '430200');
INSERT INTO `region` VALUES ('430211', '天元区', '430200');
INSERT INTO `region` VALUES ('430221', '株洲县', '430200');
INSERT INTO `region` VALUES ('430223', '攸　县', '430200');
INSERT INTO `region` VALUES ('430224', '茶陵县', '430200');
INSERT INTO `region` VALUES ('430225', '炎陵县', '430200');
INSERT INTO `region` VALUES ('430281', '醴陵市', '430200');
INSERT INTO `region` VALUES ('430301', '市辖区', '430300');
INSERT INTO `region` VALUES ('430302', '雨湖区', '430300');
INSERT INTO `region` VALUES ('430304', '岳塘区', '430300');
INSERT INTO `region` VALUES ('430321', '湘潭县', '430300');
INSERT INTO `region` VALUES ('430381', '湘乡市', '430300');
INSERT INTO `region` VALUES ('430382', '韶山市', '430300');
INSERT INTO `region` VALUES ('430401', '市辖区', '430400');
INSERT INTO `region` VALUES ('430405', '珠晖区', '430400');
INSERT INTO `region` VALUES ('430406', '雁峰区', '430400');
INSERT INTO `region` VALUES ('430407', '石鼓区', '430400');
INSERT INTO `region` VALUES ('430408', '蒸湘区', '430400');
INSERT INTO `region` VALUES ('430412', '南岳区', '430400');
INSERT INTO `region` VALUES ('430421', '衡阳县', '430400');
INSERT INTO `region` VALUES ('430422', '衡南县', '430400');
INSERT INTO `region` VALUES ('430423', '衡山县', '430400');
INSERT INTO `region` VALUES ('430424', '衡东县', '430400');
INSERT INTO `region` VALUES ('430426', '祁东县', '430400');
INSERT INTO `region` VALUES ('430481', '耒阳市', '430400');
INSERT INTO `region` VALUES ('430482', '常宁市', '430400');
INSERT INTO `region` VALUES ('430501', '市辖区', '430500');
INSERT INTO `region` VALUES ('430502', '双清区', '430500');
INSERT INTO `region` VALUES ('430503', '大祥区', '430500');
INSERT INTO `region` VALUES ('430511', '北塔区', '430500');
INSERT INTO `region` VALUES ('430521', '邵东县', '430500');
INSERT INTO `region` VALUES ('430522', '新邵县', '430500');
INSERT INTO `region` VALUES ('430523', '邵阳县', '430500');
INSERT INTO `region` VALUES ('430524', '隆回县', '430500');
INSERT INTO `region` VALUES ('430525', '洞口县', '430500');
INSERT INTO `region` VALUES ('430527', '绥宁县', '430500');
INSERT INTO `region` VALUES ('430528', '新宁县', '430500');
INSERT INTO `region` VALUES ('430529', '城步苗族自治县', '430500');
INSERT INTO `region` VALUES ('430581', '武冈市', '430500');
INSERT INTO `region` VALUES ('430601', '市辖区', '430600');
INSERT INTO `region` VALUES ('430602', '岳阳楼区', '430600');
INSERT INTO `region` VALUES ('430603', '云溪区', '430600');
INSERT INTO `region` VALUES ('430611', '君山区', '430600');
INSERT INTO `region` VALUES ('430621', '岳阳县', '430600');
INSERT INTO `region` VALUES ('430623', '华容县', '430600');
INSERT INTO `region` VALUES ('430624', '湘阴县', '430600');
INSERT INTO `region` VALUES ('430626', '平江县', '430600');
INSERT INTO `region` VALUES ('430681', '汨罗市', '430600');
INSERT INTO `region` VALUES ('430682', '临湘市', '430600');
INSERT INTO `region` VALUES ('430701', '市辖区', '430700');
INSERT INTO `region` VALUES ('430702', '武陵区', '430700');
INSERT INTO `region` VALUES ('430703', '鼎城区', '430700');
INSERT INTO `region` VALUES ('430721', '安乡县', '430700');
INSERT INTO `region` VALUES ('430722', '汉寿县', '430700');
INSERT INTO `region` VALUES ('430723', '澧　县', '430700');
INSERT INTO `region` VALUES ('430724', '临澧县', '430700');
INSERT INTO `region` VALUES ('430725', '桃源县', '430700');
INSERT INTO `region` VALUES ('430726', '石门县', '430700');
INSERT INTO `region` VALUES ('430781', '津市市', '430700');
INSERT INTO `region` VALUES ('430801', '市辖区', '430800');
INSERT INTO `region` VALUES ('430802', '永定区', '430800');
INSERT INTO `region` VALUES ('430811', '武陵源区', '430800');
INSERT INTO `region` VALUES ('430821', '慈利县', '430800');
INSERT INTO `region` VALUES ('430822', '桑植县', '430800');
INSERT INTO `region` VALUES ('430901', '市辖区', '430900');
INSERT INTO `region` VALUES ('430902', '资阳区', '430900');
INSERT INTO `region` VALUES ('430903', '赫山区', '430900');
INSERT INTO `region` VALUES ('430921', '南　县', '430900');
INSERT INTO `region` VALUES ('430922', '桃江县', '430900');
INSERT INTO `region` VALUES ('430923', '安化县', '430900');
INSERT INTO `region` VALUES ('430981', '沅江市', '430900');
INSERT INTO `region` VALUES ('431001', '市辖区', '431000');
INSERT INTO `region` VALUES ('431002', '北湖区', '431000');
INSERT INTO `region` VALUES ('431003', '苏仙区', '431000');
INSERT INTO `region` VALUES ('431021', '桂阳县', '431000');
INSERT INTO `region` VALUES ('431022', '宜章县', '431000');
INSERT INTO `region` VALUES ('431023', '永兴县', '431000');
INSERT INTO `region` VALUES ('431024', '嘉禾县', '431000');
INSERT INTO `region` VALUES ('431025', '临武县', '431000');
INSERT INTO `region` VALUES ('431026', '汝城县', '431000');
INSERT INTO `region` VALUES ('431027', '桂东县', '431000');
INSERT INTO `region` VALUES ('431028', '安仁县', '431000');
INSERT INTO `region` VALUES ('431081', '资兴市', '431000');
INSERT INTO `region` VALUES ('431101', '市辖区', '431100');
INSERT INTO `region` VALUES ('431102', '芝山区', '431100');
INSERT INTO `region` VALUES ('431103', '冷水滩区', '431100');
INSERT INTO `region` VALUES ('431121', '祁阳县', '431100');
INSERT INTO `region` VALUES ('431122', '东安县', '431100');
INSERT INTO `region` VALUES ('431123', '双牌县', '431100');
INSERT INTO `region` VALUES ('431124', '道　县', '431100');
INSERT INTO `region` VALUES ('431125', '江永县', '431100');
INSERT INTO `region` VALUES ('431126', '宁远县', '431100');
INSERT INTO `region` VALUES ('431127', '蓝山县', '431100');
INSERT INTO `region` VALUES ('431128', '新田县', '431100');
INSERT INTO `region` VALUES ('431129', '江华瑶族自治县', '431100');
INSERT INTO `region` VALUES ('431201', '市辖区', '431200');
INSERT INTO `region` VALUES ('431202', '鹤城区', '431200');
INSERT INTO `region` VALUES ('431221', '中方县', '431200');
INSERT INTO `region` VALUES ('431222', '沅陵县', '431200');
INSERT INTO `region` VALUES ('431223', '辰溪县', '431200');
INSERT INTO `region` VALUES ('431224', '溆浦县', '431200');
INSERT INTO `region` VALUES ('431225', '会同县', '431200');
INSERT INTO `region` VALUES ('431226', '麻阳苗族自治县', '431200');
INSERT INTO `region` VALUES ('431227', '新晃侗族自治县', '431200');
INSERT INTO `region` VALUES ('431228', '芷江侗族自治县', '431200');
INSERT INTO `region` VALUES ('431229', '靖州苗族侗族自治县', '431200');
INSERT INTO `region` VALUES ('431230', '通道侗族自治县', '431200');
INSERT INTO `region` VALUES ('431281', '洪江市', '431200');
INSERT INTO `region` VALUES ('431301', '市辖区', '431300');
INSERT INTO `region` VALUES ('431302', '娄星区', '431300');
INSERT INTO `region` VALUES ('431321', '双峰县', '431300');
INSERT INTO `region` VALUES ('431322', '新化县', '431300');
INSERT INTO `region` VALUES ('431381', '冷水江市', '431300');
INSERT INTO `region` VALUES ('431382', '涟源市', '431300');
INSERT INTO `region` VALUES ('433101', '吉首市', '433100');
INSERT INTO `region` VALUES ('433122', '泸溪县', '433100');
INSERT INTO `region` VALUES ('433123', '凤凰县', '433100');
INSERT INTO `region` VALUES ('433124', '花垣县', '433100');
INSERT INTO `region` VALUES ('433125', '保靖县', '433100');
INSERT INTO `region` VALUES ('433126', '古丈县', '433100');
INSERT INTO `region` VALUES ('433127', '永顺县', '433100');
INSERT INTO `region` VALUES ('433130', '龙山县', '433100');
INSERT INTO `region` VALUES ('440101', '市辖区', '440100');
INSERT INTO `region` VALUES ('440102', '东山区', '440100');
INSERT INTO `region` VALUES ('440103', '荔湾区', '440100');
INSERT INTO `region` VALUES ('440104', '越秀区', '440100');
INSERT INTO `region` VALUES ('440105', '海珠区', '440100');
INSERT INTO `region` VALUES ('440106', '天河区', '440100');
INSERT INTO `region` VALUES ('440107', '芳村区', '440100');
INSERT INTO `region` VALUES ('440111', '白云区', '440100');
INSERT INTO `region` VALUES ('440112', '黄埔区', '440100');
INSERT INTO `region` VALUES ('440113', '番禺区', '440100');
INSERT INTO `region` VALUES ('440114', '花都区', '440100');
INSERT INTO `region` VALUES ('440183', '增城市', '440100');
INSERT INTO `region` VALUES ('440184', '从化市', '440100');
INSERT INTO `region` VALUES ('440201', '市辖区', '440200');
INSERT INTO `region` VALUES ('440203', '武江区', '440200');
INSERT INTO `region` VALUES ('440204', '浈江区', '440200');
INSERT INTO `region` VALUES ('440205', '曲江区', '440200');
INSERT INTO `region` VALUES ('440222', '始兴县', '440200');
INSERT INTO `region` VALUES ('440224', '仁化县', '440200');
INSERT INTO `region` VALUES ('440229', '翁源县', '440200');
INSERT INTO `region` VALUES ('440232', '乳源瑶族自治县', '440200');
INSERT INTO `region` VALUES ('440233', '新丰县', '440200');
INSERT INTO `region` VALUES ('440281', '乐昌市', '440200');
INSERT INTO `region` VALUES ('440282', '南雄市', '440200');
INSERT INTO `region` VALUES ('440301', '市辖区', '440300');
INSERT INTO `region` VALUES ('440303', '罗湖区', '440300');
INSERT INTO `region` VALUES ('440304', '福田区', '440300');
INSERT INTO `region` VALUES ('440305', '南山区', '440300');
INSERT INTO `region` VALUES ('440306', '宝安区', '440300');
INSERT INTO `region` VALUES ('440307', '龙岗区', '440300');
INSERT INTO `region` VALUES ('440308', '盐田区', '440300');
INSERT INTO `region` VALUES ('440401', '市辖区', '440400');
INSERT INTO `region` VALUES ('440402', '香洲区', '440400');
INSERT INTO `region` VALUES ('440403', '斗门区', '440400');
INSERT INTO `region` VALUES ('440404', '金湾区', '440400');
INSERT INTO `region` VALUES ('440501', '市辖区', '440500');
INSERT INTO `region` VALUES ('440507', '龙湖区', '440500');
INSERT INTO `region` VALUES ('440511', '金平区', '440500');
INSERT INTO `region` VALUES ('440512', '濠江区', '440500');
INSERT INTO `region` VALUES ('440513', '潮阳区', '440500');
INSERT INTO `region` VALUES ('440514', '潮南区', '440500');
INSERT INTO `region` VALUES ('440515', '澄海区', '440500');
INSERT INTO `region` VALUES ('440523', '南澳县', '440500');
INSERT INTO `region` VALUES ('440601', '市辖区', '440600');
INSERT INTO `region` VALUES ('440604', '禅城区', '440600');
INSERT INTO `region` VALUES ('440605', '南海区', '440600');
INSERT INTO `region` VALUES ('440606', '顺德区', '440600');
INSERT INTO `region` VALUES ('440607', '三水区', '440600');
INSERT INTO `region` VALUES ('440608', '高明区', '440600');
INSERT INTO `region` VALUES ('440701', '市辖区', '440700');
INSERT INTO `region` VALUES ('440703', '蓬江区', '440700');
INSERT INTO `region` VALUES ('440704', '江海区', '440700');
INSERT INTO `region` VALUES ('440705', '新会区', '440700');
INSERT INTO `region` VALUES ('440781', '台山市', '440700');
INSERT INTO `region` VALUES ('440783', '开平市', '440700');
INSERT INTO `region` VALUES ('440784', '鹤山市', '440700');
INSERT INTO `region` VALUES ('440785', '恩平市', '440700');
INSERT INTO `region` VALUES ('440801', '市辖区', '440800');
INSERT INTO `region` VALUES ('440802', '赤坎区', '440800');
INSERT INTO `region` VALUES ('440803', '霞山区', '440800');
INSERT INTO `region` VALUES ('440804', '坡头区', '440800');
INSERT INTO `region` VALUES ('440811', '麻章区', '440800');
INSERT INTO `region` VALUES ('440823', '遂溪县', '440800');
INSERT INTO `region` VALUES ('440825', '徐闻县', '440800');
INSERT INTO `region` VALUES ('440881', '廉江市', '440800');
INSERT INTO `region` VALUES ('440882', '雷州市', '440800');
INSERT INTO `region` VALUES ('440883', '吴川市', '440800');
INSERT INTO `region` VALUES ('440901', '市辖区', '440900');
INSERT INTO `region` VALUES ('440902', '茂南区', '440900');
INSERT INTO `region` VALUES ('440903', '茂港区', '440900');
INSERT INTO `region` VALUES ('440923', '电白县', '440900');
INSERT INTO `region` VALUES ('440981', '高州市', '440900');
INSERT INTO `region` VALUES ('440982', '化州市', '440900');
INSERT INTO `region` VALUES ('440983', '信宜市', '440900');
INSERT INTO `region` VALUES ('441201', '市辖区', '441200');
INSERT INTO `region` VALUES ('441202', '端州区', '441200');
INSERT INTO `region` VALUES ('441203', '鼎湖区', '441200');
INSERT INTO `region` VALUES ('441223', '广宁县', '441200');
INSERT INTO `region` VALUES ('441224', '怀集县', '441200');
INSERT INTO `region` VALUES ('441225', '封开县', '441200');
INSERT INTO `region` VALUES ('441226', '德庆县', '441200');
INSERT INTO `region` VALUES ('441283', '高要市', '441200');
INSERT INTO `region` VALUES ('441284', '四会市', '441200');
INSERT INTO `region` VALUES ('441301', '市辖区', '441300');
INSERT INTO `region` VALUES ('441302', '惠城区', '441300');
INSERT INTO `region` VALUES ('441303', '惠阳区', '441300');
INSERT INTO `region` VALUES ('441322', '博罗县', '441300');
INSERT INTO `region` VALUES ('441323', '惠东县', '441300');
INSERT INTO `region` VALUES ('441324', '龙门县', '441300');
INSERT INTO `region` VALUES ('441401', '市辖区', '441400');
INSERT INTO `region` VALUES ('441402', '梅江区', '441400');
INSERT INTO `region` VALUES ('441421', '梅　县', '441400');
INSERT INTO `region` VALUES ('441422', '大埔县', '441400');
INSERT INTO `region` VALUES ('441423', '丰顺县', '441400');
INSERT INTO `region` VALUES ('441424', '五华县', '441400');
INSERT INTO `region` VALUES ('441426', '平远县', '441400');
INSERT INTO `region` VALUES ('441427', '蕉岭县', '441400');
INSERT INTO `region` VALUES ('441481', '兴宁市', '441400');
INSERT INTO `region` VALUES ('441501', '市辖区', '441500');
INSERT INTO `region` VALUES ('441502', '城　区', '441500');
INSERT INTO `region` VALUES ('441521', '海丰县', '441500');
INSERT INTO `region` VALUES ('441523', '陆河县', '441500');
INSERT INTO `region` VALUES ('441581', '陆丰市', '441500');
INSERT INTO `region` VALUES ('441601', '市辖区', '441600');
INSERT INTO `region` VALUES ('441602', '源城区', '441600');
INSERT INTO `region` VALUES ('441621', '紫金县', '441600');
INSERT INTO `region` VALUES ('441622', '龙川县', '441600');
INSERT INTO `region` VALUES ('441623', '连平县', '441600');
INSERT INTO `region` VALUES ('441624', '和平县', '441600');
INSERT INTO `region` VALUES ('441625', '东源县', '441600');
INSERT INTO `region` VALUES ('441701', '市辖区', '441700');
INSERT INTO `region` VALUES ('441702', '江城区', '441700');
INSERT INTO `region` VALUES ('441721', '阳西县', '441700');
INSERT INTO `region` VALUES ('441723', '阳东县', '441700');
INSERT INTO `region` VALUES ('441781', '阳春市', '441700');
INSERT INTO `region` VALUES ('441801', '市辖区', '441800');
INSERT INTO `region` VALUES ('441802', '清城区', '441800');
INSERT INTO `region` VALUES ('441821', '佛冈县', '441800');
INSERT INTO `region` VALUES ('441823', '阳山县', '441800');
INSERT INTO `region` VALUES ('441825', '连山壮族瑶族自治县', '441800');
INSERT INTO `region` VALUES ('441826', '连南瑶族自治县', '441800');
INSERT INTO `region` VALUES ('441827', '清新县', '441800');
INSERT INTO `region` VALUES ('441881', '英德市', '441800');
INSERT INTO `region` VALUES ('441882', '连州市', '441800');
INSERT INTO `region` VALUES ('445101', '市辖区', '445100');
INSERT INTO `region` VALUES ('445102', '湘桥区', '445100');
INSERT INTO `region` VALUES ('445121', '潮安县', '445100');
INSERT INTO `region` VALUES ('445122', '饶平县', '445100');
INSERT INTO `region` VALUES ('445201', '市辖区', '445200');
INSERT INTO `region` VALUES ('445202', '榕城区', '445200');
INSERT INTO `region` VALUES ('445221', '揭东县', '445200');
INSERT INTO `region` VALUES ('445222', '揭西县', '445200');
INSERT INTO `region` VALUES ('445224', '惠来县', '445200');
INSERT INTO `region` VALUES ('445281', '普宁市', '445200');
INSERT INTO `region` VALUES ('445301', '市辖区', '445300');
INSERT INTO `region` VALUES ('445302', '云城区', '445300');
INSERT INTO `region` VALUES ('445321', '新兴县', '445300');
INSERT INTO `region` VALUES ('445322', '郁南县', '445300');
INSERT INTO `region` VALUES ('445323', '云安县', '445300');
INSERT INTO `region` VALUES ('445381', '罗定市', '445300');
INSERT INTO `region` VALUES ('450101', '市辖区', '450100');
INSERT INTO `region` VALUES ('450102', '兴宁区', '450100');
INSERT INTO `region` VALUES ('450103', '青秀区', '450100');
INSERT INTO `region` VALUES ('450105', '江南区', '450100');
INSERT INTO `region` VALUES ('450107', '西乡塘区', '450100');
INSERT INTO `region` VALUES ('450108', '良庆区', '450100');
INSERT INTO `region` VALUES ('450109', '邕宁区', '450100');
INSERT INTO `region` VALUES ('450122', '武鸣县', '450100');
INSERT INTO `region` VALUES ('450123', '隆安县', '450100');
INSERT INTO `region` VALUES ('450124', '马山县', '450100');
INSERT INTO `region` VALUES ('450125', '上林县', '450100');
INSERT INTO `region` VALUES ('450126', '宾阳县', '450100');
INSERT INTO `region` VALUES ('450127', '横　县', '450100');
INSERT INTO `region` VALUES ('450201', '市辖区', '450200');
INSERT INTO `region` VALUES ('450202', '城中区', '450200');
INSERT INTO `region` VALUES ('450203', '鱼峰区', '450200');
INSERT INTO `region` VALUES ('450204', '柳南区', '450200');
INSERT INTO `region` VALUES ('450205', '柳北区', '450200');
INSERT INTO `region` VALUES ('450221', '柳江县', '450200');
INSERT INTO `region` VALUES ('450222', '柳城县', '450200');
INSERT INTO `region` VALUES ('450223', '鹿寨县', '450200');
INSERT INTO `region` VALUES ('450224', '融安县', '450200');
INSERT INTO `region` VALUES ('450225', '融水苗族自治县', '450200');
INSERT INTO `region` VALUES ('450226', '三江侗族自治县', '450200');
INSERT INTO `region` VALUES ('450301', '市辖区', '450300');
INSERT INTO `region` VALUES ('450302', '秀峰区', '450300');
INSERT INTO `region` VALUES ('450303', '叠彩区', '450300');
INSERT INTO `region` VALUES ('450304', '象山区', '450300');
INSERT INTO `region` VALUES ('450305', '七星区', '450300');
INSERT INTO `region` VALUES ('450311', '雁山区', '450300');
INSERT INTO `region` VALUES ('450321', '阳朔县', '450300');
INSERT INTO `region` VALUES ('450322', '临桂县', '450300');
INSERT INTO `region` VALUES ('450323', '灵川县', '450300');
INSERT INTO `region` VALUES ('450324', '全州县', '450300');
INSERT INTO `region` VALUES ('450325', '兴安县', '450300');
INSERT INTO `region` VALUES ('450326', '永福县', '450300');
INSERT INTO `region` VALUES ('450327', '灌阳县', '450300');
INSERT INTO `region` VALUES ('450328', '龙胜各族自治县', '450300');
INSERT INTO `region` VALUES ('450329', '资源县', '450300');
INSERT INTO `region` VALUES ('450330', '平乐县', '450300');
INSERT INTO `region` VALUES ('450331', '荔蒲县', '450300');
INSERT INTO `region` VALUES ('450332', '恭城瑶族自治县', '450300');
INSERT INTO `region` VALUES ('450401', '市辖区', '450400');
INSERT INTO `region` VALUES ('450403', '万秀区', '450400');
INSERT INTO `region` VALUES ('450404', '蝶山区', '450400');
INSERT INTO `region` VALUES ('450405', '长洲区', '450400');
INSERT INTO `region` VALUES ('450421', '苍梧县', '450400');
INSERT INTO `region` VALUES ('450422', '藤　县', '450400');
INSERT INTO `region` VALUES ('450423', '蒙山县', '450400');
INSERT INTO `region` VALUES ('450481', '岑溪市', '450400');
INSERT INTO `region` VALUES ('450501', '市辖区', '450500');
INSERT INTO `region` VALUES ('450502', '海城区', '450500');
INSERT INTO `region` VALUES ('450503', '银海区', '450500');
INSERT INTO `region` VALUES ('450512', '铁山港区', '450500');
INSERT INTO `region` VALUES ('450521', '合浦县', '450500');
INSERT INTO `region` VALUES ('450601', '市辖区', '450600');
INSERT INTO `region` VALUES ('450602', '港口区', '450600');
INSERT INTO `region` VALUES ('450603', '防城区', '450600');
INSERT INTO `region` VALUES ('450621', '上思县', '450600');
INSERT INTO `region` VALUES ('450681', '东兴市', '450600');
INSERT INTO `region` VALUES ('450701', '市辖区', '450700');
INSERT INTO `region` VALUES ('450702', '钦南区', '450700');
INSERT INTO `region` VALUES ('450703', '钦北区', '450700');
INSERT INTO `region` VALUES ('450721', '灵山县', '450700');
INSERT INTO `region` VALUES ('450722', '浦北县', '450700');
INSERT INTO `region` VALUES ('450801', '市辖区', '450800');
INSERT INTO `region` VALUES ('450802', '港北区', '450800');
INSERT INTO `region` VALUES ('450803', '港南区', '450800');
INSERT INTO `region` VALUES ('450804', '覃塘区', '450800');
INSERT INTO `region` VALUES ('450821', '平南县', '450800');
INSERT INTO `region` VALUES ('450881', '桂平市', '450800');
INSERT INTO `region` VALUES ('450901', '市辖区', '450900');
INSERT INTO `region` VALUES ('450902', '玉州区', '450900');
INSERT INTO `region` VALUES ('450921', '容　县', '450900');
INSERT INTO `region` VALUES ('450922', '陆川县', '450900');
INSERT INTO `region` VALUES ('450923', '博白县', '450900');
INSERT INTO `region` VALUES ('450924', '兴业县', '450900');
INSERT INTO `region` VALUES ('450981', '北流市', '450900');
INSERT INTO `region` VALUES ('451001', '市辖区', '451000');
INSERT INTO `region` VALUES ('451002', '右江区', '451000');
INSERT INTO `region` VALUES ('451021', '田阳县', '451000');
INSERT INTO `region` VALUES ('451022', '田东县', '451000');
INSERT INTO `region` VALUES ('451023', '平果县', '451000');
INSERT INTO `region` VALUES ('451024', '德保县', '451000');
INSERT INTO `region` VALUES ('451025', '靖西县', '451000');
INSERT INTO `region` VALUES ('451026', '那坡县', '451000');
INSERT INTO `region` VALUES ('451027', '凌云县', '451000');
INSERT INTO `region` VALUES ('451028', '乐业县', '451000');
INSERT INTO `region` VALUES ('451029', '田林县', '451000');
INSERT INTO `region` VALUES ('451030', '西林县', '451000');
INSERT INTO `region` VALUES ('451031', '隆林各族自治县', '451000');
INSERT INTO `region` VALUES ('451101', '市辖区', '451100');
INSERT INTO `region` VALUES ('451102', '八步区', '451100');
INSERT INTO `region` VALUES ('451121', '昭平县', '451100');
INSERT INTO `region` VALUES ('451122', '钟山县', '451100');
INSERT INTO `region` VALUES ('451123', '富川瑶族自治县', '451100');
INSERT INTO `region` VALUES ('451201', '市辖区', '451200');
INSERT INTO `region` VALUES ('451202', '金城江区', '451200');
INSERT INTO `region` VALUES ('451221', '南丹县', '451200');
INSERT INTO `region` VALUES ('451222', '天峨县', '451200');
INSERT INTO `region` VALUES ('451223', '凤山县', '451200');
INSERT INTO `region` VALUES ('451224', '东兰县', '451200');
INSERT INTO `region` VALUES ('451225', '罗城仫佬族自治县', '451200');
INSERT INTO `region` VALUES ('451226', '环江毛南族自治县', '451200');
INSERT INTO `region` VALUES ('451227', '巴马瑶族自治县', '451200');
INSERT INTO `region` VALUES ('451228', '都安瑶族自治县', '451200');
INSERT INTO `region` VALUES ('451229', '大化瑶族自治县', '451200');
INSERT INTO `region` VALUES ('451281', '宜州市', '451200');
INSERT INTO `region` VALUES ('451301', '市辖区', '451300');
INSERT INTO `region` VALUES ('451302', '兴宾区', '451300');
INSERT INTO `region` VALUES ('451321', '忻城县', '451300');
INSERT INTO `region` VALUES ('451322', '象州县', '451300');
INSERT INTO `region` VALUES ('451323', '武宣县', '451300');
INSERT INTO `region` VALUES ('451324', '金秀瑶族自治县', '451300');
INSERT INTO `region` VALUES ('451381', '合山市', '451300');
INSERT INTO `region` VALUES ('451401', '市辖区', '451400');
INSERT INTO `region` VALUES ('451402', '江洲区', '451400');
INSERT INTO `region` VALUES ('451421', '扶绥县', '451400');
INSERT INTO `region` VALUES ('451422', '宁明县', '451400');
INSERT INTO `region` VALUES ('451423', '龙州县', '451400');
INSERT INTO `region` VALUES ('451424', '大新县', '451400');
INSERT INTO `region` VALUES ('451425', '天等县', '451400');
INSERT INTO `region` VALUES ('451481', '凭祥市', '451400');
INSERT INTO `region` VALUES ('460101', '市辖区', '460100');
INSERT INTO `region` VALUES ('460105', '秀英区', '460100');
INSERT INTO `region` VALUES ('460106', '龙华区', '460100');
INSERT INTO `region` VALUES ('460107', '琼山区', '460100');
INSERT INTO `region` VALUES ('460108', '美兰区', '460100');
INSERT INTO `region` VALUES ('460201', '市辖区', '460200');
INSERT INTO `region` VALUES ('469001', '五指山市', '469000');
INSERT INTO `region` VALUES ('469002', '琼海市', '469000');
INSERT INTO `region` VALUES ('469003', '儋州市', '469000');
INSERT INTO `region` VALUES ('469005', '文昌市', '469000');
INSERT INTO `region` VALUES ('469006', '万宁市', '469000');
INSERT INTO `region` VALUES ('469007', '东方市', '469000');
INSERT INTO `region` VALUES ('469025', '定安县', '469000');
INSERT INTO `region` VALUES ('469026', '屯昌县', '469000');
INSERT INTO `region` VALUES ('469027', '澄迈县', '469000');
INSERT INTO `region` VALUES ('469028', '临高县', '469000');
INSERT INTO `region` VALUES ('469030', '白沙黎族自治县', '469000');
INSERT INTO `region` VALUES ('469031', '昌江黎族自治县', '469000');
INSERT INTO `region` VALUES ('469033', '乐东黎族自治县', '469000');
INSERT INTO `region` VALUES ('469034', '陵水黎族自治县', '469000');
INSERT INTO `region` VALUES ('469035', '保亭黎族苗族自治县', '469000');
INSERT INTO `region` VALUES ('469036', '琼中黎族苗族自治县', '469000');
INSERT INTO `region` VALUES ('469037', '西沙群岛', '469000');
INSERT INTO `region` VALUES ('469038', '南沙群岛', '469000');
INSERT INTO `region` VALUES ('469039', '中沙群岛的岛礁及其海域', '469000');
INSERT INTO `region` VALUES ('500101', '万州区', '500100');
INSERT INTO `region` VALUES ('500102', '涪陵区', '500100');
INSERT INTO `region` VALUES ('500103', '渝中区', '500100');
INSERT INTO `region` VALUES ('500104', '大渡口区', '500100');
INSERT INTO `region` VALUES ('500105', '江北区', '500100');
INSERT INTO `region` VALUES ('500106', '沙坪坝区', '500100');
INSERT INTO `region` VALUES ('500107', '九龙坡区', '500100');
INSERT INTO `region` VALUES ('500108', '南岸区', '500100');
INSERT INTO `region` VALUES ('500109', '北碚区', '500100');
INSERT INTO `region` VALUES ('500110', '万盛区', '500100');
INSERT INTO `region` VALUES ('500111', '双桥区', '500100');
INSERT INTO `region` VALUES ('500112', '渝北区', '500100');
INSERT INTO `region` VALUES ('500113', '巴南区', '500100');
INSERT INTO `region` VALUES ('500114', '黔江区', '500100');
INSERT INTO `region` VALUES ('500115', '长寿区', '500100');
INSERT INTO `region` VALUES ('500222', '綦江县', '500200');
INSERT INTO `region` VALUES ('500223', '潼南县', '500200');
INSERT INTO `region` VALUES ('500224', '铜梁县', '500200');
INSERT INTO `region` VALUES ('500225', '大足县', '500200');
INSERT INTO `region` VALUES ('500226', '荣昌县', '500200');
INSERT INTO `region` VALUES ('500227', '璧山县', '500200');
INSERT INTO `region` VALUES ('500228', '梁平县', '500200');
INSERT INTO `region` VALUES ('500229', '城口县', '500200');
INSERT INTO `region` VALUES ('500230', '丰都县', '500200');
INSERT INTO `region` VALUES ('500231', '垫江县', '500200');
INSERT INTO `region` VALUES ('500232', '武隆县', '500200');
INSERT INTO `region` VALUES ('500233', '忠　县', '500200');
INSERT INTO `region` VALUES ('500234', '开　县', '500200');
INSERT INTO `region` VALUES ('500235', '云阳县', '500200');
INSERT INTO `region` VALUES ('500236', '奉节县', '500200');
INSERT INTO `region` VALUES ('500237', '巫山县', '500200');
INSERT INTO `region` VALUES ('500238', '巫溪县', '500200');
INSERT INTO `region` VALUES ('500240', '石柱土家族自治县', '500200');
INSERT INTO `region` VALUES ('500241', '秀山土家族苗族自治县', '500200');
INSERT INTO `region` VALUES ('500242', '酉阳土家族苗族自治县', '500200');
INSERT INTO `region` VALUES ('500243', '彭水苗族土家族自治县', '500200');
INSERT INTO `region` VALUES ('500381', '江津市', '500300');
INSERT INTO `region` VALUES ('500382', '合川市', '500300');
INSERT INTO `region` VALUES ('500383', '永川市', '500300');
INSERT INTO `region` VALUES ('500384', '南川市', '500300');
INSERT INTO `region` VALUES ('510101', '市辖区', '510100');
INSERT INTO `region` VALUES ('510104', '锦江区', '510100');
INSERT INTO `region` VALUES ('510105', '青羊区', '510100');
INSERT INTO `region` VALUES ('510106', '金牛区', '510100');
INSERT INTO `region` VALUES ('510107', '武侯区', '510100');
INSERT INTO `region` VALUES ('510108', '成华区', '510100');
INSERT INTO `region` VALUES ('510112', '龙泉驿区', '510100');
INSERT INTO `region` VALUES ('510113', '青白江区', '510100');
INSERT INTO `region` VALUES ('510114', '新都区', '510100');
INSERT INTO `region` VALUES ('510115', '温江县', '510100');
INSERT INTO `region` VALUES ('510121', '金堂县', '510100');
INSERT INTO `region` VALUES ('510122', '双流县', '510100');
INSERT INTO `region` VALUES ('510124', '郫　县', '510100');
INSERT INTO `region` VALUES ('510129', '大邑县', '510100');
INSERT INTO `region` VALUES ('510131', '蒲江县', '510100');
INSERT INTO `region` VALUES ('510132', '新津县', '510100');
INSERT INTO `region` VALUES ('510181', '都江堰市', '510100');
INSERT INTO `region` VALUES ('510182', '彭州市', '510100');
INSERT INTO `region` VALUES ('510183', '邛崃市', '510100');
INSERT INTO `region` VALUES ('510184', '崇州市', '510100');
INSERT INTO `region` VALUES ('510301', '市辖区', '510300');
INSERT INTO `region` VALUES ('510302', '自流井区', '510300');
INSERT INTO `region` VALUES ('510303', '贡井区', '510300');
INSERT INTO `region` VALUES ('510304', '大安区', '510300');
INSERT INTO `region` VALUES ('510311', '沿滩区', '510300');
INSERT INTO `region` VALUES ('510321', '荣　县', '510300');
INSERT INTO `region` VALUES ('510322', '富顺县', '510300');
INSERT INTO `region` VALUES ('510401', '市辖区', '510400');
INSERT INTO `region` VALUES ('510402', '东　区', '510400');
INSERT INTO `region` VALUES ('510403', '西　区', '510400');
INSERT INTO `region` VALUES ('510411', '仁和区', '510400');
INSERT INTO `region` VALUES ('510421', '米易县', '510400');
INSERT INTO `region` VALUES ('510422', '盐边县', '510400');
INSERT INTO `region` VALUES ('510501', '市辖区', '510500');
INSERT INTO `region` VALUES ('510502', '江阳区', '510500');
INSERT INTO `region` VALUES ('510503', '纳溪区', '510500');
INSERT INTO `region` VALUES ('510504', '龙马潭区', '510500');
INSERT INTO `region` VALUES ('510521', '泸　县', '510500');
INSERT INTO `region` VALUES ('510522', '合江县', '510500');
INSERT INTO `region` VALUES ('510524', '叙永县', '510500');
INSERT INTO `region` VALUES ('510525', '古蔺县', '510500');
INSERT INTO `region` VALUES ('510601', '市辖区', '510600');
INSERT INTO `region` VALUES ('510603', '旌阳区', '510600');
INSERT INTO `region` VALUES ('510623', '中江县', '510600');
INSERT INTO `region` VALUES ('510626', '罗江县', '510600');
INSERT INTO `region` VALUES ('510681', '广汉市', '510600');
INSERT INTO `region` VALUES ('510682', '什邡市', '510600');
INSERT INTO `region` VALUES ('510683', '绵竹市', '510600');
INSERT INTO `region` VALUES ('510701', '市辖区', '510700');
INSERT INTO `region` VALUES ('510703', '涪城区', '510700');
INSERT INTO `region` VALUES ('510704', '游仙区', '510700');
INSERT INTO `region` VALUES ('510722', '三台县', '510700');
INSERT INTO `region` VALUES ('510723', '盐亭县', '510700');
INSERT INTO `region` VALUES ('510724', '安　县', '510700');
INSERT INTO `region` VALUES ('510725', '梓潼县', '510700');
INSERT INTO `region` VALUES ('510726', '北川羌族自治县', '510700');
INSERT INTO `region` VALUES ('510727', '平武县', '510700');
INSERT INTO `region` VALUES ('510781', '江油市', '510700');
INSERT INTO `region` VALUES ('510801', '市辖区', '510800');
INSERT INTO `region` VALUES ('510802', '市中区', '510800');
INSERT INTO `region` VALUES ('510811', '元坝区', '510800');
INSERT INTO `region` VALUES ('510812', '朝天区', '510800');
INSERT INTO `region` VALUES ('510821', '旺苍县', '510800');
INSERT INTO `region` VALUES ('510822', '青川县', '510800');
INSERT INTO `region` VALUES ('510823', '剑阁县', '510800');
INSERT INTO `region` VALUES ('510824', '苍溪县', '510800');
INSERT INTO `region` VALUES ('510901', '市辖区', '510900');
INSERT INTO `region` VALUES ('510903', '船山区', '510900');
INSERT INTO `region` VALUES ('510904', '安居区', '510900');
INSERT INTO `region` VALUES ('510921', '蓬溪县', '510900');
INSERT INTO `region` VALUES ('510922', '射洪县', '510900');
INSERT INTO `region` VALUES ('510923', '大英县', '510900');
INSERT INTO `region` VALUES ('511001', '市辖区', '511000');
INSERT INTO `region` VALUES ('511002', '市中区', '511000');
INSERT INTO `region` VALUES ('511011', '东兴区', '511000');
INSERT INTO `region` VALUES ('511024', '威远县', '511000');
INSERT INTO `region` VALUES ('511025', '资中县', '511000');
INSERT INTO `region` VALUES ('511028', '隆昌县', '511000');
INSERT INTO `region` VALUES ('511101', '市辖区', '511100');
INSERT INTO `region` VALUES ('511102', '市中区', '511100');
INSERT INTO `region` VALUES ('511111', '沙湾区', '511100');
INSERT INTO `region` VALUES ('511112', '五通桥区', '511100');
INSERT INTO `region` VALUES ('511113', '金口河区', '511100');
INSERT INTO `region` VALUES ('511123', '犍为县', '511100');
INSERT INTO `region` VALUES ('511124', '井研县', '511100');
INSERT INTO `region` VALUES ('511126', '夹江县', '511100');
INSERT INTO `region` VALUES ('511129', '沐川县', '511100');
INSERT INTO `region` VALUES ('511132', '峨边彝族自治县', '511100');
INSERT INTO `region` VALUES ('511133', '马边彝族自治县', '511100');
INSERT INTO `region` VALUES ('511181', '峨眉山市', '511100');
INSERT INTO `region` VALUES ('511301', '市辖区', '511300');
INSERT INTO `region` VALUES ('511302', '顺庆区', '511300');
INSERT INTO `region` VALUES ('511303', '高坪区', '511300');
INSERT INTO `region` VALUES ('511304', '嘉陵区', '511300');
INSERT INTO `region` VALUES ('511321', '南部县', '511300');
INSERT INTO `region` VALUES ('511322', '营山县', '511300');
INSERT INTO `region` VALUES ('511323', '蓬安县', '511300');
INSERT INTO `region` VALUES ('511324', '仪陇县', '511300');
INSERT INTO `region` VALUES ('511325', '西充县', '511300');
INSERT INTO `region` VALUES ('511381', '阆中市', '511300');
INSERT INTO `region` VALUES ('511401', '市辖区', '511400');
INSERT INTO `region` VALUES ('511402', '东坡区', '511400');
INSERT INTO `region` VALUES ('511421', '仁寿县', '511400');
INSERT INTO `region` VALUES ('511422', '彭山县', '511400');
INSERT INTO `region` VALUES ('511423', '洪雅县', '511400');
INSERT INTO `region` VALUES ('511424', '丹棱县', '511400');
INSERT INTO `region` VALUES ('511425', '青神县', '511400');
INSERT INTO `region` VALUES ('511501', '市辖区', '511500');
INSERT INTO `region` VALUES ('511502', '翠屏区', '511500');
INSERT INTO `region` VALUES ('511521', '宜宾县', '511500');
INSERT INTO `region` VALUES ('511522', '南溪县', '511500');
INSERT INTO `region` VALUES ('511523', '江安县', '511500');
INSERT INTO `region` VALUES ('511524', '长宁县', '511500');
INSERT INTO `region` VALUES ('511525', '高　县', '511500');
INSERT INTO `region` VALUES ('511526', '珙　县', '511500');
INSERT INTO `region` VALUES ('511527', '筠连县', '511500');
INSERT INTO `region` VALUES ('511528', '兴文县', '511500');
INSERT INTO `region` VALUES ('511529', '屏山县', '511500');
INSERT INTO `region` VALUES ('511601', '市辖区', '511600');
INSERT INTO `region` VALUES ('511602', '广安区', '511600');
INSERT INTO `region` VALUES ('511621', '岳池县', '511600');
INSERT INTO `region` VALUES ('511622', '武胜县', '511600');
INSERT INTO `region` VALUES ('511623', '邻水县', '511600');
INSERT INTO `region` VALUES ('511681', '华莹市', '511600');
INSERT INTO `region` VALUES ('511701', '市辖区', '511700');
INSERT INTO `region` VALUES ('511702', '通川区', '511700');
INSERT INTO `region` VALUES ('511721', '达　县', '511700');
INSERT INTO `region` VALUES ('511722', '宣汉县', '511700');
INSERT INTO `region` VALUES ('511723', '开江县', '511700');
INSERT INTO `region` VALUES ('511724', '大竹县', '511700');
INSERT INTO `region` VALUES ('511725', '渠　县', '511700');
INSERT INTO `region` VALUES ('511781', '万源市', '511700');
INSERT INTO `region` VALUES ('511801', '市辖区', '511800');
INSERT INTO `region` VALUES ('511802', '雨城区', '511800');
INSERT INTO `region` VALUES ('511821', '名山县', '511800');
INSERT INTO `region` VALUES ('511822', '荥经县', '511800');
INSERT INTO `region` VALUES ('511823', '汉源县', '511800');
INSERT INTO `region` VALUES ('511824', '石棉县', '511800');
INSERT INTO `region` VALUES ('511825', '天全县', '511800');
INSERT INTO `region` VALUES ('511826', '芦山县', '511800');
INSERT INTO `region` VALUES ('511827', '宝兴县', '511800');
INSERT INTO `region` VALUES ('511901', '市辖区', '511900');
INSERT INTO `region` VALUES ('511902', '巴州区', '511900');
INSERT INTO `region` VALUES ('511921', '通江县', '511900');
INSERT INTO `region` VALUES ('511922', '南江县', '511900');
INSERT INTO `region` VALUES ('511923', '平昌县', '511900');
INSERT INTO `region` VALUES ('512001', '市辖区', '512000');
INSERT INTO `region` VALUES ('512002', '雁江区', '512000');
INSERT INTO `region` VALUES ('512021', '安岳县', '512000');
INSERT INTO `region` VALUES ('512022', '乐至县', '512000');
INSERT INTO `region` VALUES ('512081', '简阳市', '512000');
INSERT INTO `region` VALUES ('513221', '汶川县', '513200');
INSERT INTO `region` VALUES ('513222', '理　县', '513200');
INSERT INTO `region` VALUES ('513223', '茂　县', '513200');
INSERT INTO `region` VALUES ('513224', '松潘县', '513200');
INSERT INTO `region` VALUES ('513225', '九寨沟县', '513200');
INSERT INTO `region` VALUES ('513226', '金川县', '513200');
INSERT INTO `region` VALUES ('513227', '小金县', '513200');
INSERT INTO `region` VALUES ('513228', '黑水县', '513200');
INSERT INTO `region` VALUES ('513229', '马尔康县', '513200');
INSERT INTO `region` VALUES ('513230', '壤塘县', '513200');
INSERT INTO `region` VALUES ('513231', '阿坝县', '513200');
INSERT INTO `region` VALUES ('513232', '若尔盖县', '513200');
INSERT INTO `region` VALUES ('513233', '红原县', '513200');
INSERT INTO `region` VALUES ('513321', '康定县', '513300');
INSERT INTO `region` VALUES ('513322', '泸定县', '513300');
INSERT INTO `region` VALUES ('513323', '丹巴县', '513300');
INSERT INTO `region` VALUES ('513324', '九龙县', '513300');
INSERT INTO `region` VALUES ('513325', '雅江县', '513300');
INSERT INTO `region` VALUES ('513326', '道孚县', '513300');
INSERT INTO `region` VALUES ('513327', '炉霍县', '513300');
INSERT INTO `region` VALUES ('513328', '甘孜县', '513300');
INSERT INTO `region` VALUES ('513329', '新龙县', '513300');
INSERT INTO `region` VALUES ('513330', '德格县', '513300');
INSERT INTO `region` VALUES ('513331', '白玉县', '513300');
INSERT INTO `region` VALUES ('513332', '石渠县', '513300');
INSERT INTO `region` VALUES ('513333', '色达县', '513300');
INSERT INTO `region` VALUES ('513334', '理塘县', '513300');
INSERT INTO `region` VALUES ('513335', '巴塘县', '513300');
INSERT INTO `region` VALUES ('513336', '乡城县', '513300');
INSERT INTO `region` VALUES ('513337', '稻城县', '513300');
INSERT INTO `region` VALUES ('513338', '得荣县', '513300');
INSERT INTO `region` VALUES ('513401', '西昌市', '513400');
INSERT INTO `region` VALUES ('513422', '木里藏族自治县', '513400');
INSERT INTO `region` VALUES ('513423', '盐源县', '513400');
INSERT INTO `region` VALUES ('513424', '德昌县', '513400');
INSERT INTO `region` VALUES ('513425', '会理县', '513400');
INSERT INTO `region` VALUES ('513426', '会东县', '513400');
INSERT INTO `region` VALUES ('513427', '宁南县', '513400');
INSERT INTO `region` VALUES ('513428', '普格县', '513400');
INSERT INTO `region` VALUES ('513429', '布拖县', '513400');
INSERT INTO `region` VALUES ('513430', '金阳县', '513400');
INSERT INTO `region` VALUES ('513431', '昭觉县', '513400');
INSERT INTO `region` VALUES ('513432', '喜德县', '513400');
INSERT INTO `region` VALUES ('513433', '冕宁县', '513400');
INSERT INTO `region` VALUES ('513434', '越西县', '513400');
INSERT INTO `region` VALUES ('513435', '甘洛县', '513400');
INSERT INTO `region` VALUES ('513436', '美姑县', '513400');
INSERT INTO `region` VALUES ('513437', '雷波县', '513400');
INSERT INTO `region` VALUES ('520101', '市辖区', '520100');
INSERT INTO `region` VALUES ('520102', '南明区', '520100');
INSERT INTO `region` VALUES ('520103', '云岩区', '520100');
INSERT INTO `region` VALUES ('520111', '花溪区', '520100');
INSERT INTO `region` VALUES ('520112', '乌当区', '520100');
INSERT INTO `region` VALUES ('520113', '白云区', '520100');
INSERT INTO `region` VALUES ('520114', '小河区', '520100');
INSERT INTO `region` VALUES ('520121', '开阳县', '520100');
INSERT INTO `region` VALUES ('520122', '息烽县', '520100');
INSERT INTO `region` VALUES ('520123', '修文县', '520100');
INSERT INTO `region` VALUES ('520181', '清镇市', '520100');
INSERT INTO `region` VALUES ('520201', '钟山区', '520200');
INSERT INTO `region` VALUES ('520203', '六枝特区', '520200');
INSERT INTO `region` VALUES ('520221', '水城县', '520200');
INSERT INTO `region` VALUES ('520222', '盘　县', '520200');
INSERT INTO `region` VALUES ('520301', '市辖区', '520300');
INSERT INTO `region` VALUES ('520302', '红花岗区', '520300');
INSERT INTO `region` VALUES ('520303', '汇川区', '520300');
INSERT INTO `region` VALUES ('520321', '遵义县', '520300');
INSERT INTO `region` VALUES ('520322', '桐梓县', '520300');
INSERT INTO `region` VALUES ('520323', '绥阳县', '520300');
INSERT INTO `region` VALUES ('520324', '正安县', '520300');
INSERT INTO `region` VALUES ('520325', '道真仡佬族苗族自治县', '520300');
INSERT INTO `region` VALUES ('520326', '务川仡佬族苗族自治县', '520300');
INSERT INTO `region` VALUES ('520327', '凤冈县', '520300');
INSERT INTO `region` VALUES ('520328', '湄潭县', '520300');
INSERT INTO `region` VALUES ('520329', '余庆县', '520300');
INSERT INTO `region` VALUES ('520330', '习水县', '520300');
INSERT INTO `region` VALUES ('520381', '赤水市', '520300');
INSERT INTO `region` VALUES ('520382', '仁怀市', '520300');
INSERT INTO `region` VALUES ('520401', '市辖区', '520400');
INSERT INTO `region` VALUES ('520402', '西秀区', '520400');
INSERT INTO `region` VALUES ('520421', '平坝县', '520400');
INSERT INTO `region` VALUES ('520422', '普定县', '520400');
INSERT INTO `region` VALUES ('520423', '镇宁布依族苗族自治县', '520400');
INSERT INTO `region` VALUES ('520424', '关岭布依族苗族自治县', '520400');
INSERT INTO `region` VALUES ('520425', '紫云苗族布依族自治县', '520400');
INSERT INTO `region` VALUES ('522201', '铜仁市', '522200');
INSERT INTO `region` VALUES ('522222', '江口县', '522200');
INSERT INTO `region` VALUES ('522223', '玉屏侗族自治县', '522200');
INSERT INTO `region` VALUES ('522224', '石阡县', '522200');
INSERT INTO `region` VALUES ('522225', '思南县', '522200');
INSERT INTO `region` VALUES ('522226', '印江土家族苗族自治县', '522200');
INSERT INTO `region` VALUES ('522227', '德江县', '522200');
INSERT INTO `region` VALUES ('522228', '沿河土家族自治县', '522200');
INSERT INTO `region` VALUES ('522229', '松桃苗族自治县', '522200');
INSERT INTO `region` VALUES ('522230', '万山特区', '522200');
INSERT INTO `region` VALUES ('522301', '兴义市', '522300');
INSERT INTO `region` VALUES ('522322', '兴仁县', '522300');
INSERT INTO `region` VALUES ('522323', '普安县', '522300');
INSERT INTO `region` VALUES ('522324', '晴隆县', '522300');
INSERT INTO `region` VALUES ('522325', '贞丰县', '522300');
INSERT INTO `region` VALUES ('522326', '望谟县', '522300');
INSERT INTO `region` VALUES ('522327', '册亨县', '522300');
INSERT INTO `region` VALUES ('522328', '安龙县', '522300');
INSERT INTO `region` VALUES ('522401', '毕节市', '522400');
INSERT INTO `region` VALUES ('522422', '大方县', '522400');
INSERT INTO `region` VALUES ('522423', '黔西县', '522400');
INSERT INTO `region` VALUES ('522424', '金沙县', '522400');
INSERT INTO `region` VALUES ('522425', '织金县', '522400');
INSERT INTO `region` VALUES ('522426', '纳雍县', '522400');
INSERT INTO `region` VALUES ('522427', '威宁彝族回族苗族自治县', '522400');
INSERT INTO `region` VALUES ('522428', '赫章县', '522400');
INSERT INTO `region` VALUES ('522601', '凯里市', '522600');
INSERT INTO `region` VALUES ('522622', '黄平县', '522600');
INSERT INTO `region` VALUES ('522623', '施秉县', '522600');
INSERT INTO `region` VALUES ('522624', '三穗县', '522600');
INSERT INTO `region` VALUES ('522625', '镇远县', '522600');
INSERT INTO `region` VALUES ('522626', '岑巩县', '522600');
INSERT INTO `region` VALUES ('522627', '天柱县', '522600');
INSERT INTO `region` VALUES ('522628', '锦屏县', '522600');
INSERT INTO `region` VALUES ('522629', '剑河县', '522600');
INSERT INTO `region` VALUES ('522630', '台江县', '522600');
INSERT INTO `region` VALUES ('522631', '黎平县', '522600');
INSERT INTO `region` VALUES ('522632', '榕江县', '522600');
INSERT INTO `region` VALUES ('522633', '从江县', '522600');
INSERT INTO `region` VALUES ('522634', '雷山县', '522600');
INSERT INTO `region` VALUES ('522635', '麻江县', '522600');
INSERT INTO `region` VALUES ('522636', '丹寨县', '522600');
INSERT INTO `region` VALUES ('522701', '都匀市', '522700');
INSERT INTO `region` VALUES ('522702', '福泉市', '522700');
INSERT INTO `region` VALUES ('522722', '荔波县', '522700');
INSERT INTO `region` VALUES ('522723', '贵定县', '522700');
INSERT INTO `region` VALUES ('522725', '瓮安县', '522700');
INSERT INTO `region` VALUES ('522726', '独山县', '522700');
INSERT INTO `region` VALUES ('522727', '平塘县', '522700');
INSERT INTO `region` VALUES ('522728', '罗甸县', '522700');
INSERT INTO `region` VALUES ('522729', '长顺县', '522700');
INSERT INTO `region` VALUES ('522730', '龙里县', '522700');
INSERT INTO `region` VALUES ('522731', '惠水县', '522700');
INSERT INTO `region` VALUES ('522732', '三都水族自治县', '522700');
INSERT INTO `region` VALUES ('530101', '市辖区', '530100');
INSERT INTO `region` VALUES ('530102', '五华区', '530100');
INSERT INTO `region` VALUES ('530103', '盘龙区', '530100');
INSERT INTO `region` VALUES ('530111', '官渡区', '530100');
INSERT INTO `region` VALUES ('530112', '西山区', '530100');
INSERT INTO `region` VALUES ('530113', '东川区', '530100');
INSERT INTO `region` VALUES ('530121', '呈贡县', '530100');
INSERT INTO `region` VALUES ('530122', '晋宁县', '530100');
INSERT INTO `region` VALUES ('530124', '富民县', '530100');
INSERT INTO `region` VALUES ('530125', '宜良县', '530100');
INSERT INTO `region` VALUES ('530126', '石林彝族自治县', '530100');
INSERT INTO `region` VALUES ('530127', '嵩明县', '530100');
INSERT INTO `region` VALUES ('530128', '禄劝彝族苗族自治县', '530100');
INSERT INTO `region` VALUES ('530129', '寻甸回族彝族自治县', '530100');
INSERT INTO `region` VALUES ('530181', '安宁市', '530100');
INSERT INTO `region` VALUES ('530301', '市辖区', '530300');
INSERT INTO `region` VALUES ('530302', '麒麟区', '530300');
INSERT INTO `region` VALUES ('530321', '马龙县', '530300');
INSERT INTO `region` VALUES ('530322', '陆良县', '530300');
INSERT INTO `region` VALUES ('530323', '师宗县', '530300');
INSERT INTO `region` VALUES ('530324', '罗平县', '530300');
INSERT INTO `region` VALUES ('530325', '富源县', '530300');
INSERT INTO `region` VALUES ('530326', '会泽县', '530300');
INSERT INTO `region` VALUES ('530328', '沾益县', '530300');
INSERT INTO `region` VALUES ('530381', '宣威市', '530300');
INSERT INTO `region` VALUES ('530401', '市辖区', '530400');
INSERT INTO `region` VALUES ('530402', '红塔区', '530400');
INSERT INTO `region` VALUES ('530421', '江川县', '530400');
INSERT INTO `region` VALUES ('530422', '澄江县', '530400');
INSERT INTO `region` VALUES ('530423', '通海县', '530400');
INSERT INTO `region` VALUES ('530424', '华宁县', '530400');
INSERT INTO `region` VALUES ('530425', '易门县', '530400');
INSERT INTO `region` VALUES ('530426', '峨山彝族自治县', '530400');
INSERT INTO `region` VALUES ('530427', '新平彝族傣族自治县', '530400');
INSERT INTO `region` VALUES ('530428', '元江哈尼族彝族傣族自治县', '530400');
INSERT INTO `region` VALUES ('530501', '市辖区', '530500');
INSERT INTO `region` VALUES ('530502', '隆阳区', '530500');
INSERT INTO `region` VALUES ('530521', '施甸县', '530500');
INSERT INTO `region` VALUES ('530522', '腾冲县', '530500');
INSERT INTO `region` VALUES ('530523', '龙陵县', '530500');
INSERT INTO `region` VALUES ('530524', '昌宁县', '530500');
INSERT INTO `region` VALUES ('530601', '市辖区', '530600');
INSERT INTO `region` VALUES ('530602', '昭阳区', '530600');
INSERT INTO `region` VALUES ('530621', '鲁甸县', '530600');
INSERT INTO `region` VALUES ('530622', '巧家县', '530600');
INSERT INTO `region` VALUES ('530623', '盐津县', '530600');
INSERT INTO `region` VALUES ('530624', '大关县', '530600');
INSERT INTO `region` VALUES ('530625', '永善县', '530600');
INSERT INTO `region` VALUES ('530626', '绥江县', '530600');
INSERT INTO `region` VALUES ('530627', '镇雄县', '530600');
INSERT INTO `region` VALUES ('530628', '彝良县', '530600');
INSERT INTO `region` VALUES ('530629', '威信县', '530600');
INSERT INTO `region` VALUES ('530630', '水富县', '530600');
INSERT INTO `region` VALUES ('530701', '市辖区', '530700');
INSERT INTO `region` VALUES ('530702', '古城区', '530700');
INSERT INTO `region` VALUES ('530721', '玉龙纳西族自治县', '530700');
INSERT INTO `region` VALUES ('530722', '永胜县', '530700');
INSERT INTO `region` VALUES ('530723', '华坪县', '530700');
INSERT INTO `region` VALUES ('530724', '宁蒗彝族自治县', '530700');
INSERT INTO `region` VALUES ('530801', '市辖区', '530800');
INSERT INTO `region` VALUES ('530802', '翠云区', '530800');
INSERT INTO `region` VALUES ('530821', '普洱哈尼族彝族自治县', '530800');
INSERT INTO `region` VALUES ('530822', '墨江哈尼族自治县', '530800');
INSERT INTO `region` VALUES ('530823', '景东彝族自治县', '530800');
INSERT INTO `region` VALUES ('530824', '景谷傣族彝族自治县', '530800');
INSERT INTO `region` VALUES ('530825', '镇沅彝族哈尼族拉祜族自治县', '530800');
INSERT INTO `region` VALUES ('530826', '江城哈尼族彝族自治县', '530800');
INSERT INTO `region` VALUES ('530827', '孟连傣族拉祜族佤族自治县', '530800');
INSERT INTO `region` VALUES ('530828', '澜沧拉祜族自治县', '530800');
INSERT INTO `region` VALUES ('530829', '西盟佤族自治县', '530800');
INSERT INTO `region` VALUES ('530901', '市辖区', '530900');
INSERT INTO `region` VALUES ('530902', '临翔区', '530900');
INSERT INTO `region` VALUES ('530921', '凤庆县', '530900');
INSERT INTO `region` VALUES ('530922', '云　县', '530900');
INSERT INTO `region` VALUES ('530923', '永德县', '530900');
INSERT INTO `region` VALUES ('530924', '镇康县', '530900');
INSERT INTO `region` VALUES ('530925', '双江拉祜族佤族布朗族傣族自治县', '530900');
INSERT INTO `region` VALUES ('530926', '耿马傣族佤族自治县', '530900');
INSERT INTO `region` VALUES ('530927', '沧源佤族自治县', '530900');
INSERT INTO `region` VALUES ('532301', '楚雄市', '532300');
INSERT INTO `region` VALUES ('532322', '双柏县', '532300');
INSERT INTO `region` VALUES ('532323', '牟定县', '532300');
INSERT INTO `region` VALUES ('532324', '南华县', '532300');
INSERT INTO `region` VALUES ('532325', '姚安县', '532300');
INSERT INTO `region` VALUES ('532326', '大姚县', '532300');
INSERT INTO `region` VALUES ('532327', '永仁县', '532300');
INSERT INTO `region` VALUES ('532328', '元谋县', '532300');
INSERT INTO `region` VALUES ('532329', '武定县', '532300');
INSERT INTO `region` VALUES ('532331', '禄丰县', '532300');
INSERT INTO `region` VALUES ('532501', '个旧市', '532500');
INSERT INTO `region` VALUES ('532502', '开远市', '532500');
INSERT INTO `region` VALUES ('532522', '蒙自县', '532500');
INSERT INTO `region` VALUES ('532523', '屏边苗族自治县', '532500');
INSERT INTO `region` VALUES ('532524', '建水县', '532500');
INSERT INTO `region` VALUES ('532525', '石屏县', '532500');
INSERT INTO `region` VALUES ('532526', '弥勒县', '532500');
INSERT INTO `region` VALUES ('532527', '泸西县', '532500');
INSERT INTO `region` VALUES ('532528', '元阳县', '532500');
INSERT INTO `region` VALUES ('532529', '红河县', '532500');
INSERT INTO `region` VALUES ('532530', '金平苗族瑶族傣族自治县', '532500');
INSERT INTO `region` VALUES ('532531', '绿春县', '532500');
INSERT INTO `region` VALUES ('532532', '河口瑶族自治县', '532500');
INSERT INTO `region` VALUES ('532621', '文山县', '532600');
INSERT INTO `region` VALUES ('532622', '砚山县', '532600');
INSERT INTO `region` VALUES ('532623', '西畴县', '532600');
INSERT INTO `region` VALUES ('532624', '麻栗坡县', '532600');
INSERT INTO `region` VALUES ('532625', '马关县', '532600');
INSERT INTO `region` VALUES ('532626', '丘北县', '532600');
INSERT INTO `region` VALUES ('532627', '广南县', '532600');
INSERT INTO `region` VALUES ('532628', '富宁县', '532600');
INSERT INTO `region` VALUES ('532801', '景洪市', '532800');
INSERT INTO `region` VALUES ('532822', '勐海县', '532800');
INSERT INTO `region` VALUES ('532823', '勐腊县', '532800');
INSERT INTO `region` VALUES ('532901', '大理市', '532900');
INSERT INTO `region` VALUES ('532922', '漾濞彝族自治县', '532900');
INSERT INTO `region` VALUES ('532923', '祥云县', '532900');
INSERT INTO `region` VALUES ('532924', '宾川县', '532900');
INSERT INTO `region` VALUES ('532925', '弥渡县', '532900');
INSERT INTO `region` VALUES ('532926', '南涧彝族自治县', '532900');
INSERT INTO `region` VALUES ('532927', '巍山彝族回族自治县', '532900');
INSERT INTO `region` VALUES ('532928', '永平县', '532900');
INSERT INTO `region` VALUES ('532929', '云龙县', '532900');
INSERT INTO `region` VALUES ('532930', '洱源县', '532900');
INSERT INTO `region` VALUES ('532931', '剑川县', '532900');
INSERT INTO `region` VALUES ('532932', '鹤庆县', '532900');
INSERT INTO `region` VALUES ('533102', '瑞丽市', '533100');
INSERT INTO `region` VALUES ('533103', '潞西市', '533100');
INSERT INTO `region` VALUES ('533122', '梁河县', '533100');
INSERT INTO `region` VALUES ('533123', '盈江县', '533100');
INSERT INTO `region` VALUES ('533124', '陇川县', '533100');
INSERT INTO `region` VALUES ('533321', '泸水县', '533300');
INSERT INTO `region` VALUES ('533323', '福贡县', '533300');
INSERT INTO `region` VALUES ('533324', '贡山独龙族怒族自治县', '533300');
INSERT INTO `region` VALUES ('533325', '兰坪白族普米族自治县', '533300');
INSERT INTO `region` VALUES ('533421', '香格里拉县', '533400');
INSERT INTO `region` VALUES ('533422', '德钦县', '533400');
INSERT INTO `region` VALUES ('533423', '维西傈僳族自治县', '533400');
INSERT INTO `region` VALUES ('540101', '市辖区', '540100');
INSERT INTO `region` VALUES ('540102', '城关区', '540100');
INSERT INTO `region` VALUES ('540121', '林周县', '540100');
INSERT INTO `region` VALUES ('540122', '当雄县', '540100');
INSERT INTO `region` VALUES ('540123', '尼木县', '540100');
INSERT INTO `region` VALUES ('540124', '曲水县', '540100');
INSERT INTO `region` VALUES ('540125', '堆龙德庆县', '540100');
INSERT INTO `region` VALUES ('540126', '达孜县', '540100');
INSERT INTO `region` VALUES ('540127', '墨竹工卡县', '540100');
INSERT INTO `region` VALUES ('542121', '昌都县', '542100');
INSERT INTO `region` VALUES ('542122', '江达县', '542100');
INSERT INTO `region` VALUES ('542123', '贡觉县', '542100');
INSERT INTO `region` VALUES ('542124', '类乌齐县', '542100');
INSERT INTO `region` VALUES ('542125', '丁青县', '542100');
INSERT INTO `region` VALUES ('542126', '察雅县', '542100');
INSERT INTO `region` VALUES ('542127', '八宿县', '542100');
INSERT INTO `region` VALUES ('542128', '左贡县', '542100');
INSERT INTO `region` VALUES ('542129', '芒康县', '542100');
INSERT INTO `region` VALUES ('542132', '洛隆县', '542100');
INSERT INTO `region` VALUES ('542133', '边坝县', '542100');
INSERT INTO `region` VALUES ('542221', '乃东县', '542200');
INSERT INTO `region` VALUES ('542222', '扎囊县', '542200');
INSERT INTO `region` VALUES ('542223', '贡嘎县', '542200');
INSERT INTO `region` VALUES ('542224', '桑日县', '542200');
INSERT INTO `region` VALUES ('542225', '琼结县', '542200');
INSERT INTO `region` VALUES ('542226', '曲松县', '542200');
INSERT INTO `region` VALUES ('542227', '措美县', '542200');
INSERT INTO `region` VALUES ('542228', '洛扎县', '542200');
INSERT INTO `region` VALUES ('542229', '加查县', '542200');
INSERT INTO `region` VALUES ('542231', '隆子县', '542200');
INSERT INTO `region` VALUES ('542232', '错那县', '542200');
INSERT INTO `region` VALUES ('542233', '浪卡子县', '542200');
INSERT INTO `region` VALUES ('542301', '日喀则市', '542300');
INSERT INTO `region` VALUES ('542322', '南木林县', '542300');
INSERT INTO `region` VALUES ('542323', '江孜县', '542300');
INSERT INTO `region` VALUES ('542324', '定日县', '542300');
INSERT INTO `region` VALUES ('542325', '萨迦县', '542300');
INSERT INTO `region` VALUES ('542326', '拉孜县', '542300');
INSERT INTO `region` VALUES ('542327', '昂仁县', '542300');
INSERT INTO `region` VALUES ('542328', '谢通门县', '542300');
INSERT INTO `region` VALUES ('542329', '白朗县', '542300');
INSERT INTO `region` VALUES ('542330', '仁布县', '542300');
INSERT INTO `region` VALUES ('542331', '康马县', '542300');
INSERT INTO `region` VALUES ('542332', '定结县', '542300');
INSERT INTO `region` VALUES ('542333', '仲巴县', '542300');
INSERT INTO `region` VALUES ('542334', '亚东县', '542300');
INSERT INTO `region` VALUES ('542335', '吉隆县', '542300');
INSERT INTO `region` VALUES ('542336', '聂拉木县', '542300');
INSERT INTO `region` VALUES ('542337', '萨嘎县', '542300');
INSERT INTO `region` VALUES ('542338', '岗巴县', '542300');
INSERT INTO `region` VALUES ('542421', '那曲县', '542400');
INSERT INTO `region` VALUES ('542422', '嘉黎县', '542400');
INSERT INTO `region` VALUES ('542423', '比如县', '542400');
INSERT INTO `region` VALUES ('542424', '聂荣县', '542400');
INSERT INTO `region` VALUES ('542425', '安多县', '542400');
INSERT INTO `region` VALUES ('542426', '申扎县', '542400');
INSERT INTO `region` VALUES ('542427', '索　县', '542400');
INSERT INTO `region` VALUES ('542428', '班戈县', '542400');
INSERT INTO `region` VALUES ('542429', '巴青县', '542400');
INSERT INTO `region` VALUES ('542430', '尼玛县', '542400');
INSERT INTO `region` VALUES ('542521', '普兰县', '542500');
INSERT INTO `region` VALUES ('542522', '札达县', '542500');
INSERT INTO `region` VALUES ('542523', '噶尔县', '542500');
INSERT INTO `region` VALUES ('542524', '日土县', '542500');
INSERT INTO `region` VALUES ('542525', '革吉县', '542500');
INSERT INTO `region` VALUES ('542526', '改则县', '542500');
INSERT INTO `region` VALUES ('542527', '措勤县', '542500');
INSERT INTO `region` VALUES ('542621', '林芝县', '542600');
INSERT INTO `region` VALUES ('542622', '工布江达县', '542600');
INSERT INTO `region` VALUES ('542623', '米林县', '542600');
INSERT INTO `region` VALUES ('542624', '墨脱县', '542600');
INSERT INTO `region` VALUES ('542625', '波密县', '542600');
INSERT INTO `region` VALUES ('542626', '察隅县', '542600');
INSERT INTO `region` VALUES ('542627', '朗　县', '542600');
INSERT INTO `region` VALUES ('610101', '市辖区', '610100');
INSERT INTO `region` VALUES ('610102', '新城区', '610100');
INSERT INTO `region` VALUES ('610103', '碑林区', '610100');
INSERT INTO `region` VALUES ('610104', '莲湖区', '610100');
INSERT INTO `region` VALUES ('610111', '灞桥区', '610100');
INSERT INTO `region` VALUES ('610112', '未央区', '610100');
INSERT INTO `region` VALUES ('610113', '雁塔区', '610100');
INSERT INTO `region` VALUES ('610114', '阎良区', '610100');
INSERT INTO `region` VALUES ('610115', '临潼区', '610100');
INSERT INTO `region` VALUES ('610116', '长安区', '610100');
INSERT INTO `region` VALUES ('610122', '蓝田县', '610100');
INSERT INTO `region` VALUES ('610124', '周至县', '610100');
INSERT INTO `region` VALUES ('610125', '户　县', '610100');
INSERT INTO `region` VALUES ('610126', '高陵县', '610100');
INSERT INTO `region` VALUES ('610201', '市辖区', '610200');
INSERT INTO `region` VALUES ('610202', '王益区', '610200');
INSERT INTO `region` VALUES ('610203', '印台区', '610200');
INSERT INTO `region` VALUES ('610204', '耀州区', '610200');
INSERT INTO `region` VALUES ('610222', '宜君县', '610200');
INSERT INTO `region` VALUES ('610301', '市辖区', '610300');
INSERT INTO `region` VALUES ('610302', '渭滨区', '610300');
INSERT INTO `region` VALUES ('610303', '金台区', '610300');
INSERT INTO `region` VALUES ('610304', '陈仓区', '610300');
INSERT INTO `region` VALUES ('610322', '凤翔县', '610300');
INSERT INTO `region` VALUES ('610323', '岐山县', '610300');
INSERT INTO `region` VALUES ('610324', '扶风县', '610300');
INSERT INTO `region` VALUES ('610326', '眉　县', '610300');
INSERT INTO `region` VALUES ('610327', '陇　县', '610300');
INSERT INTO `region` VALUES ('610328', '千阳县', '610300');
INSERT INTO `region` VALUES ('610329', '麟游县', '610300');
INSERT INTO `region` VALUES ('610330', '凤　县', '610300');
INSERT INTO `region` VALUES ('610331', '太白县', '610300');
INSERT INTO `region` VALUES ('610401', '市辖区', '610400');
INSERT INTO `region` VALUES ('610402', '秦都区', '610400');
INSERT INTO `region` VALUES ('610403', '杨凌区', '610400');
INSERT INTO `region` VALUES ('610404', '渭城区', '610400');
INSERT INTO `region` VALUES ('610422', '三原县', '610400');
INSERT INTO `region` VALUES ('610423', '泾阳县', '610400');
INSERT INTO `region` VALUES ('610424', '乾　县', '610400');
INSERT INTO `region` VALUES ('610425', '礼泉县', '610400');
INSERT INTO `region` VALUES ('610426', '永寿县', '610400');
INSERT INTO `region` VALUES ('610427', '彬　县', '610400');
INSERT INTO `region` VALUES ('610428', '长武县', '610400');
INSERT INTO `region` VALUES ('610429', '旬邑县', '610400');
INSERT INTO `region` VALUES ('610430', '淳化县', '610400');
INSERT INTO `region` VALUES ('610431', '武功县', '610400');
INSERT INTO `region` VALUES ('610481', '兴平市', '610400');
INSERT INTO `region` VALUES ('610501', '市辖区', '610500');
INSERT INTO `region` VALUES ('610502', '临渭区', '610500');
INSERT INTO `region` VALUES ('610521', '华　县', '610500');
INSERT INTO `region` VALUES ('610522', '潼关县', '610500');
INSERT INTO `region` VALUES ('610523', '大荔县', '610500');
INSERT INTO `region` VALUES ('610524', '合阳县', '610500');
INSERT INTO `region` VALUES ('610525', '澄城县', '610500');
INSERT INTO `region` VALUES ('610526', '蒲城县', '610500');
INSERT INTO `region` VALUES ('610527', '白水县', '610500');
INSERT INTO `region` VALUES ('610528', '富平县', '610500');
INSERT INTO `region` VALUES ('610581', '韩城市', '610500');
INSERT INTO `region` VALUES ('610582', '华阴市', '610500');
INSERT INTO `region` VALUES ('610601', '市辖区', '610600');
INSERT INTO `region` VALUES ('610602', '宝塔区', '610600');
INSERT INTO `region` VALUES ('610621', '延长县', '610600');
INSERT INTO `region` VALUES ('610622', '延川县', '610600');
INSERT INTO `region` VALUES ('610623', '子长县', '610600');
INSERT INTO `region` VALUES ('610624', '安塞县', '610600');
INSERT INTO `region` VALUES ('610625', '志丹县', '610600');
INSERT INTO `region` VALUES ('610626', '吴旗县', '610600');
INSERT INTO `region` VALUES ('610627', '甘泉县', '610600');
INSERT INTO `region` VALUES ('610628', '富　县', '610600');
INSERT INTO `region` VALUES ('610629', '洛川县', '610600');
INSERT INTO `region` VALUES ('610630', '宜川县', '610600');
INSERT INTO `region` VALUES ('610631', '黄龙县', '610600');
INSERT INTO `region` VALUES ('610632', '黄陵县', '610600');
INSERT INTO `region` VALUES ('610701', '市辖区', '610700');
INSERT INTO `region` VALUES ('610702', '汉台区', '610700');
INSERT INTO `region` VALUES ('610721', '南郑县', '610700');
INSERT INTO `region` VALUES ('610722', '城固县', '610700');
INSERT INTO `region` VALUES ('610723', '洋　县', '610700');
INSERT INTO `region` VALUES ('610724', '西乡县', '610700');
INSERT INTO `region` VALUES ('610725', '勉　县', '610700');
INSERT INTO `region` VALUES ('610726', '宁强县', '610700');
INSERT INTO `region` VALUES ('610727', '略阳县', '610700');
INSERT INTO `region` VALUES ('610728', '镇巴县', '610700');
INSERT INTO `region` VALUES ('610729', '留坝县', '610700');
INSERT INTO `region` VALUES ('610730', '佛坪县', '610700');
INSERT INTO `region` VALUES ('610801', '市辖区', '610800');
INSERT INTO `region` VALUES ('610802', '榆阳区', '610800');
INSERT INTO `region` VALUES ('610821', '神木县', '610800');
INSERT INTO `region` VALUES ('610822', '府谷县', '610800');
INSERT INTO `region` VALUES ('610823', '横山县', '610800');
INSERT INTO `region` VALUES ('610824', '靖边县', '610800');
INSERT INTO `region` VALUES ('610825', '定边县', '610800');
INSERT INTO `region` VALUES ('610826', '绥德县', '610800');
INSERT INTO `region` VALUES ('610827', '米脂县', '610800');
INSERT INTO `region` VALUES ('610828', '佳　县', '610800');
INSERT INTO `region` VALUES ('610829', '吴堡县', '610800');
INSERT INTO `region` VALUES ('610830', '清涧县', '610800');
INSERT INTO `region` VALUES ('610831', '子洲县', '610800');
INSERT INTO `region` VALUES ('610901', '市辖区', '610900');
INSERT INTO `region` VALUES ('610902', '汉滨区', '610900');
INSERT INTO `region` VALUES ('610921', '汉阴县', '610900');
INSERT INTO `region` VALUES ('610922', '石泉县', '610900');
INSERT INTO `region` VALUES ('610923', '宁陕县', '610900');
INSERT INTO `region` VALUES ('610924', '紫阳县', '610900');
INSERT INTO `region` VALUES ('610925', '岚皋县', '610900');
INSERT INTO `region` VALUES ('610926', '平利县', '610900');
INSERT INTO `region` VALUES ('610927', '镇坪县', '610900');
INSERT INTO `region` VALUES ('610928', '旬阳县', '610900');
INSERT INTO `region` VALUES ('610929', '白河县', '610900');
INSERT INTO `region` VALUES ('611001', '市辖区', '611000');
INSERT INTO `region` VALUES ('611002', '商州区', '611000');
INSERT INTO `region` VALUES ('611021', '洛南县', '611000');
INSERT INTO `region` VALUES ('611022', '丹凤县', '611000');
INSERT INTO `region` VALUES ('611023', '商南县', '611000');
INSERT INTO `region` VALUES ('611024', '山阳县', '611000');
INSERT INTO `region` VALUES ('611025', '镇安县', '611000');
INSERT INTO `region` VALUES ('611026', '柞水县', '611000');
INSERT INTO `region` VALUES ('620101', '市辖区', '620100');
INSERT INTO `region` VALUES ('620102', '城关区', '620100');
INSERT INTO `region` VALUES ('620103', '七里河区', '620100');
INSERT INTO `region` VALUES ('620104', '西固区', '620100');
INSERT INTO `region` VALUES ('620105', '安宁区', '620100');
INSERT INTO `region` VALUES ('620111', '红古区', '620100');
INSERT INTO `region` VALUES ('620121', '永登县', '620100');
INSERT INTO `region` VALUES ('620122', '皋兰县', '620100');
INSERT INTO `region` VALUES ('620123', '榆中县', '620100');
INSERT INTO `region` VALUES ('620201', '市辖区', '620200');
INSERT INTO `region` VALUES ('620301', '市辖区', '620300');
INSERT INTO `region` VALUES ('620302', '金川区', '620300');
INSERT INTO `region` VALUES ('620321', '永昌县', '620300');
INSERT INTO `region` VALUES ('620401', '市辖区', '620400');
INSERT INTO `region` VALUES ('620402', '白银区', '620400');
INSERT INTO `region` VALUES ('620403', '平川区', '620400');
INSERT INTO `region` VALUES ('620421', '靖远县', '620400');
INSERT INTO `region` VALUES ('620422', '会宁县', '620400');
INSERT INTO `region` VALUES ('620423', '景泰县', '620400');
INSERT INTO `region` VALUES ('620501', '市辖区', '620500');
INSERT INTO `region` VALUES ('620502', '秦城区', '620500');
INSERT INTO `region` VALUES ('620503', '北道区', '620500');
INSERT INTO `region` VALUES ('620521', '清水县', '620500');
INSERT INTO `region` VALUES ('620522', '秦安县', '620500');
INSERT INTO `region` VALUES ('620523', '甘谷县', '620500');
INSERT INTO `region` VALUES ('620524', '武山县', '620500');
INSERT INTO `region` VALUES ('620525', '张家川回族自治县', '620500');
INSERT INTO `region` VALUES ('620601', '市辖区', '620600');
INSERT INTO `region` VALUES ('620602', '凉州区', '620600');
INSERT INTO `region` VALUES ('620621', '民勤县', '620600');
INSERT INTO `region` VALUES ('620622', '古浪县', '620600');
INSERT INTO `region` VALUES ('620623', '天祝藏族自治县', '620600');
INSERT INTO `region` VALUES ('620701', '市辖区', '620700');
INSERT INTO `region` VALUES ('620702', '甘州区', '620700');
INSERT INTO `region` VALUES ('620721', '肃南裕固族自治县', '620700');
INSERT INTO `region` VALUES ('620722', '民乐县', '620700');
INSERT INTO `region` VALUES ('620723', '临泽县', '620700');
INSERT INTO `region` VALUES ('620724', '高台县', '620700');
INSERT INTO `region` VALUES ('620725', '山丹县', '620700');
INSERT INTO `region` VALUES ('620801', '市辖区', '620800');
INSERT INTO `region` VALUES ('620802', '崆峒区', '620800');
INSERT INTO `region` VALUES ('620821', '泾川县', '620800');
INSERT INTO `region` VALUES ('620822', '灵台县', '620800');
INSERT INTO `region` VALUES ('620823', '崇信县', '620800');
INSERT INTO `region` VALUES ('620824', '华亭县', '620800');
INSERT INTO `region` VALUES ('620825', '庄浪县', '620800');
INSERT INTO `region` VALUES ('620826', '静宁县', '620800');
INSERT INTO `region` VALUES ('620901', '市辖区', '620900');
INSERT INTO `region` VALUES ('620902', '肃州区', '620900');
INSERT INTO `region` VALUES ('620921', '金塔县', '620900');
INSERT INTO `region` VALUES ('620922', '安西县', '620900');
INSERT INTO `region` VALUES ('620923', '肃北蒙古族自治县', '620900');
INSERT INTO `region` VALUES ('620924', '阿克塞哈萨克族自治县', '620900');
INSERT INTO `region` VALUES ('620981', '玉门市', '620900');
INSERT INTO `region` VALUES ('620982', '敦煌市', '620900');
INSERT INTO `region` VALUES ('621001', '市辖区', '621000');
INSERT INTO `region` VALUES ('621002', '西峰区', '621000');
INSERT INTO `region` VALUES ('621021', '庆城县', '621000');
INSERT INTO `region` VALUES ('621022', '环　县', '621000');
INSERT INTO `region` VALUES ('621023', '华池县', '621000');
INSERT INTO `region` VALUES ('621024', '合水县', '621000');
INSERT INTO `region` VALUES ('621025', '正宁县', '621000');
INSERT INTO `region` VALUES ('621026', '宁　县', '621000');
INSERT INTO `region` VALUES ('621027', '镇原县', '621000');
INSERT INTO `region` VALUES ('621101', '市辖区', '621100');
INSERT INTO `region` VALUES ('621102', '安定区', '621100');
INSERT INTO `region` VALUES ('621121', '通渭县', '621100');
INSERT INTO `region` VALUES ('621122', '陇西县', '621100');
INSERT INTO `region` VALUES ('621123', '渭源县', '621100');
INSERT INTO `region` VALUES ('621124', '临洮县', '621100');
INSERT INTO `region` VALUES ('621125', '漳　县', '621100');
INSERT INTO `region` VALUES ('621126', '岷　县', '621100');
INSERT INTO `region` VALUES ('621201', '市辖区', '621200');
INSERT INTO `region` VALUES ('621202', '武都区', '621200');
INSERT INTO `region` VALUES ('621221', '成　县', '621200');
INSERT INTO `region` VALUES ('621222', '文　县', '621200');
INSERT INTO `region` VALUES ('621223', '宕昌县', '621200');
INSERT INTO `region` VALUES ('621224', '康　县', '621200');
INSERT INTO `region` VALUES ('621225', '西和县', '621200');
INSERT INTO `region` VALUES ('621226', '礼　县', '621200');
INSERT INTO `region` VALUES ('621227', '徽　县', '621200');
INSERT INTO `region` VALUES ('621228', '两当县', '621200');
INSERT INTO `region` VALUES ('622901', '临夏市', '622900');
INSERT INTO `region` VALUES ('622921', '临夏县', '622900');
INSERT INTO `region` VALUES ('622922', '康乐县', '622900');
INSERT INTO `region` VALUES ('622923', '永靖县', '622900');
INSERT INTO `region` VALUES ('622924', '广河县', '622900');
INSERT INTO `region` VALUES ('622925', '和政县', '622900');
INSERT INTO `region` VALUES ('622926', '东乡族自治县', '622900');
INSERT INTO `region` VALUES ('622927', '积石山保安族东乡族撒拉族自治县', '622900');
INSERT INTO `region` VALUES ('623001', '合作市', '623000');
INSERT INTO `region` VALUES ('623021', '临潭县', '623000');
INSERT INTO `region` VALUES ('623022', '卓尼县', '623000');
INSERT INTO `region` VALUES ('623023', '舟曲县', '623000');
INSERT INTO `region` VALUES ('623024', '迭部县', '623000');
INSERT INTO `region` VALUES ('623025', '玛曲县', '623000');
INSERT INTO `region` VALUES ('623026', '碌曲县', '623000');
INSERT INTO `region` VALUES ('623027', '夏河县', '623000');
INSERT INTO `region` VALUES ('630101', '市辖区', '630100');
INSERT INTO `region` VALUES ('630102', '城东区', '630100');
INSERT INTO `region` VALUES ('630103', '城中区', '630100');
INSERT INTO `region` VALUES ('630104', '城西区', '630100');
INSERT INTO `region` VALUES ('630105', '城北区', '630100');
INSERT INTO `region` VALUES ('630121', '大通回族土族自治县', '630100');
INSERT INTO `region` VALUES ('630122', '湟中县', '630100');
INSERT INTO `region` VALUES ('630123', '湟源县', '630100');
INSERT INTO `region` VALUES ('632121', '平安县', '632100');
INSERT INTO `region` VALUES ('632122', '民和回族土族自治县', '632100');
INSERT INTO `region` VALUES ('632123', '乐都县', '632100');
INSERT INTO `region` VALUES ('632126', '互助土族自治县', '632100');
INSERT INTO `region` VALUES ('632127', '化隆回族自治县', '632100');
INSERT INTO `region` VALUES ('632128', '循化撒拉族自治县', '632100');
INSERT INTO `region` VALUES ('632221', '门源回族自治县', '632200');
INSERT INTO `region` VALUES ('632222', '祁连县', '632200');
INSERT INTO `region` VALUES ('632223', '海晏县', '632200');
INSERT INTO `region` VALUES ('632224', '刚察县', '632200');
INSERT INTO `region` VALUES ('632321', '同仁县', '632300');
INSERT INTO `region` VALUES ('632322', '尖扎县', '632300');
INSERT INTO `region` VALUES ('632323', '泽库县', '632300');
INSERT INTO `region` VALUES ('632324', '河南蒙古族自治县', '632300');
INSERT INTO `region` VALUES ('632521', '共和县', '632500');
INSERT INTO `region` VALUES ('632522', '同德县', '632500');
INSERT INTO `region` VALUES ('632523', '贵德县', '632500');
INSERT INTO `region` VALUES ('632524', '兴海县', '632500');
INSERT INTO `region` VALUES ('632525', '贵南县', '632500');
INSERT INTO `region` VALUES ('632621', '玛沁县', '632600');
INSERT INTO `region` VALUES ('632622', '班玛县', '632600');
INSERT INTO `region` VALUES ('632623', '甘德县', '632600');
INSERT INTO `region` VALUES ('632624', '达日县', '632600');
INSERT INTO `region` VALUES ('632625', '久治县', '632600');
INSERT INTO `region` VALUES ('632626', '玛多县', '632600');
INSERT INTO `region` VALUES ('632721', '玉树县', '632700');
INSERT INTO `region` VALUES ('632722', '杂多县', '632700');
INSERT INTO `region` VALUES ('632723', '称多县', '632700');
INSERT INTO `region` VALUES ('632724', '治多县', '632700');
INSERT INTO `region` VALUES ('632725', '囊谦县', '632700');
INSERT INTO `region` VALUES ('632726', '曲麻莱县', '632700');
INSERT INTO `region` VALUES ('632801', '格尔木市', '632800');
INSERT INTO `region` VALUES ('632802', '德令哈市', '632800');
INSERT INTO `region` VALUES ('632821', '乌兰县', '632800');
INSERT INTO `region` VALUES ('632822', '都兰县', '632800');
INSERT INTO `region` VALUES ('632823', '天峻县', '632800');
INSERT INTO `region` VALUES ('640101', '市辖区', '640100');
INSERT INTO `region` VALUES ('640104', '兴庆区', '640100');
INSERT INTO `region` VALUES ('640105', '西夏区', '640100');
INSERT INTO `region` VALUES ('640106', '金凤区', '640100');
INSERT INTO `region` VALUES ('640121', '永宁县', '640100');
INSERT INTO `region` VALUES ('640122', '贺兰县', '640100');
INSERT INTO `region` VALUES ('640181', '灵武市', '640100');
INSERT INTO `region` VALUES ('640201', '市辖区', '640200');
INSERT INTO `region` VALUES ('640202', '大武口区', '640200');
INSERT INTO `region` VALUES ('640205', '惠农区', '640200');
INSERT INTO `region` VALUES ('640221', '平罗县', '640200');
INSERT INTO `region` VALUES ('640301', '市辖区', '640300');
INSERT INTO `region` VALUES ('640302', '利通区', '640300');
INSERT INTO `region` VALUES ('640323', '盐池县', '640300');
INSERT INTO `region` VALUES ('640324', '同心县', '640300');
INSERT INTO `region` VALUES ('640381', '青铜峡市', '640300');
INSERT INTO `region` VALUES ('640401', '市辖区', '640400');
INSERT INTO `region` VALUES ('640402', '原州区', '640400');
INSERT INTO `region` VALUES ('640422', '西吉县', '640400');
INSERT INTO `region` VALUES ('640423', '隆德县', '640400');
INSERT INTO `region` VALUES ('640424', '泾源县', '640400');
INSERT INTO `region` VALUES ('640425', '彭阳县', '640400');
INSERT INTO `region` VALUES ('640501', '市辖区', '640500');
INSERT INTO `region` VALUES ('640502', '沙坡头区', '640500');
INSERT INTO `region` VALUES ('640521', '中宁县', '640500');
INSERT INTO `region` VALUES ('640522', '海原县', '640400');
INSERT INTO `region` VALUES ('650101', '市辖区', '650100');
INSERT INTO `region` VALUES ('650102', '天山区', '650100');
INSERT INTO `region` VALUES ('650103', '沙依巴克区', '650100');
INSERT INTO `region` VALUES ('650104', '新市区', '650100');
INSERT INTO `region` VALUES ('650105', '水磨沟区', '650100');
INSERT INTO `region` VALUES ('650106', '头屯河区', '650100');
INSERT INTO `region` VALUES ('650107', '达坂城区', '650100');
INSERT INTO `region` VALUES ('650108', '东山区', '650100');
INSERT INTO `region` VALUES ('650121', '乌鲁木齐县', '650100');
INSERT INTO `region` VALUES ('650201', '市辖区', '650200');
INSERT INTO `region` VALUES ('650202', '独山子区', '650200');
INSERT INTO `region` VALUES ('650203', '克拉玛依区', '650200');
INSERT INTO `region` VALUES ('650204', '白碱滩区', '650200');
INSERT INTO `region` VALUES ('650205', '乌尔禾区', '650200');
INSERT INTO `region` VALUES ('652101', '吐鲁番市', '652100');
INSERT INTO `region` VALUES ('652122', '鄯善县', '652100');
INSERT INTO `region` VALUES ('652123', '托克逊县', '652100');
INSERT INTO `region` VALUES ('652201', '哈密市', '652200');
INSERT INTO `region` VALUES ('652222', '巴里坤哈萨克自治县', '652200');
INSERT INTO `region` VALUES ('652223', '伊吾县', '652200');
INSERT INTO `region` VALUES ('652301', '昌吉市', '652300');
INSERT INTO `region` VALUES ('652302', '阜康市', '652300');
INSERT INTO `region` VALUES ('652303', '米泉市', '652300');
INSERT INTO `region` VALUES ('652323', '呼图壁县', '652300');
INSERT INTO `region` VALUES ('652324', '玛纳斯县', '652300');
INSERT INTO `region` VALUES ('652325', '奇台县', '652300');
INSERT INTO `region` VALUES ('652327', '吉木萨尔县', '652300');
INSERT INTO `region` VALUES ('652328', '木垒哈萨克自治县', '652300');
INSERT INTO `region` VALUES ('652701', '博乐市', '652700');
INSERT INTO `region` VALUES ('652722', '精河县', '652700');
INSERT INTO `region` VALUES ('652723', '温泉县', '652700');
INSERT INTO `region` VALUES ('652801', '库尔勒市', '652800');
INSERT INTO `region` VALUES ('652822', '轮台县', '652800');
INSERT INTO `region` VALUES ('652823', '尉犁县', '652800');
INSERT INTO `region` VALUES ('652824', '若羌县', '652800');
INSERT INTO `region` VALUES ('652825', '且末县', '652800');
INSERT INTO `region` VALUES ('652826', '焉耆回族自治县', '652800');
INSERT INTO `region` VALUES ('652827', '和静县', '652800');
INSERT INTO `region` VALUES ('652828', '和硕县', '652800');
INSERT INTO `region` VALUES ('652829', '博湖县', '652800');
INSERT INTO `region` VALUES ('652901', '阿克苏市', '652900');
INSERT INTO `region` VALUES ('652922', '温宿县', '652900');
INSERT INTO `region` VALUES ('652923', '库车县', '652900');
INSERT INTO `region` VALUES ('652924', '沙雅县', '652900');
INSERT INTO `region` VALUES ('652925', '新和县', '652900');
INSERT INTO `region` VALUES ('652926', '拜城县', '652900');
INSERT INTO `region` VALUES ('652927', '乌什县', '652900');
INSERT INTO `region` VALUES ('652928', '阿瓦提县', '652900');
INSERT INTO `region` VALUES ('652929', '柯坪县', '652900');
INSERT INTO `region` VALUES ('653001', '阿图什市', '653000');
INSERT INTO `region` VALUES ('653022', '阿克陶县', '653000');
INSERT INTO `region` VALUES ('653023', '阿合奇县', '653000');
INSERT INTO `region` VALUES ('653024', '乌恰县', '653000');
INSERT INTO `region` VALUES ('653101', '喀什市', '653100');
INSERT INTO `region` VALUES ('653121', '疏附县', '653100');
INSERT INTO `region` VALUES ('653122', '疏勒县', '653100');
INSERT INTO `region` VALUES ('653123', '英吉沙县', '653100');
INSERT INTO `region` VALUES ('653124', '泽普县', '653100');
INSERT INTO `region` VALUES ('653125', '莎车县', '653100');
INSERT INTO `region` VALUES ('653126', '叶城县', '653100');
INSERT INTO `region` VALUES ('653127', '麦盖提县', '653100');
INSERT INTO `region` VALUES ('653128', '岳普湖县', '653100');
INSERT INTO `region` VALUES ('653129', '伽师县', '653100');
INSERT INTO `region` VALUES ('653130', '巴楚县', '653100');
INSERT INTO `region` VALUES ('653131', '塔什库尔干塔吉克自治县', '653100');
INSERT INTO `region` VALUES ('653201', '和田市', '653200');
INSERT INTO `region` VALUES ('653221', '和田县', '653200');
INSERT INTO `region` VALUES ('653222', '墨玉县', '653200');
INSERT INTO `region` VALUES ('653223', '皮山县', '653200');
INSERT INTO `region` VALUES ('653224', '洛浦县', '653200');
INSERT INTO `region` VALUES ('653225', '策勒县', '653200');
INSERT INTO `region` VALUES ('653226', '于田县', '653200');
INSERT INTO `region` VALUES ('653227', '民丰县', '653200');
INSERT INTO `region` VALUES ('654002', '伊宁市', '654000');
INSERT INTO `region` VALUES ('654003', '奎屯市', '654000');
INSERT INTO `region` VALUES ('654021', '伊宁县', '654000');
INSERT INTO `region` VALUES ('654022', '察布查尔锡伯自治县', '654000');
INSERT INTO `region` VALUES ('654023', '霍城县', '654000');
INSERT INTO `region` VALUES ('654024', '巩留县', '654000');
INSERT INTO `region` VALUES ('654025', '新源县', '654000');
INSERT INTO `region` VALUES ('654026', '昭苏县', '654000');
INSERT INTO `region` VALUES ('654027', '特克斯县', '654000');
INSERT INTO `region` VALUES ('654028', '尼勒克县', '654000');
INSERT INTO `region` VALUES ('654201', '塔城市', '654200');
INSERT INTO `region` VALUES ('654202', '乌苏市', '654200');
INSERT INTO `region` VALUES ('654221', '额敏县', '654200');
INSERT INTO `region` VALUES ('654223', '沙湾县', '654200');
INSERT INTO `region` VALUES ('654224', '托里县', '654200');
INSERT INTO `region` VALUES ('654225', '裕民县', '654200');
INSERT INTO `region` VALUES ('654226', '和布克赛尔蒙古自治县', '654200');
INSERT INTO `region` VALUES ('654301', '阿勒泰市', '654300');
INSERT INTO `region` VALUES ('654321', '布尔津县', '654300');
INSERT INTO `region` VALUES ('654322', '富蕴县', '654300');
INSERT INTO `region` VALUES ('654323', '福海县', '654300');
INSERT INTO `region` VALUES ('654324', '哈巴河县', '654300');
INSERT INTO `region` VALUES ('654325', '青河县', '654300');
INSERT INTO `region` VALUES ('654326', '吉木乃县', '654300');
INSERT INTO `region` VALUES ('659001', '石河子市', '659000');
INSERT INTO `region` VALUES ('659002', '阿拉尔市', '659000');
INSERT INTO `region` VALUES ('659003', '图木舒克市', '659000');
INSERT INTO `region` VALUES ('659004', '五家渠市', '659000');

-- ----------------------------
-- Table structure for `shi_ti`
-- ----------------------------
DROP TABLE IF EXISTS `shi_ti`;
CREATE TABLE `shi_ti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) DEFAULT '0',
  `liangBiaoId` int(11) DEFAULT NULL,
  `tiHao` int(11) DEFAULT NULL,
  `tiMu` text,
  `a` varchar(255) DEFAULT NULL,
  `b` varchar(255) DEFAULT NULL,
  `c` varchar(255) DEFAULT NULL,
  `d` varchar(255) DEFAULT NULL,
  `e` varchar(255) DEFAULT NULL,
  `f` varchar(255) DEFAULT NULL,
  `g` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=506 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shi_ti
-- ----------------------------
INSERT INTO `shi_ti` VALUES ('1', '0', '1', '1', '你感到怕冷、衣服比别人穿得多吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('2', '0', '1', '2', '你感到眼睛干涩吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('3', '0', '1', '3', '你感到口感咽燥、总想喝水吗？', '无', '很少 ', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('4', '0', '1', '4', '你感到口苦或嘴里有异味吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('5', '0', '1', '5', '你有黑眼圈吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('6', '0', '1', '6', '你无缘无故叹气吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('7', '0', '1', '7', '你的皮肤一抓就红，并出现抓痕吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('8', '0', '1', '8', '你说话声音低弱无力吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('9', '0', '1', '9', '你精力充沛吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('10', '0', '1', '10', '你容易失眠吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('11', '0', '1', '11', '你感到闷闷不乐，情绪低落吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('12', '0', '1', '12', '你比别人容易患感冒吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('13', '0', '1', '13', '你胃脘部、背部或腰膝部怕冷吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('14', '0', '1', '14', '你的皮肤或口唇干吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('15', '0', '1', '15', '你腹部肥满松软吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('16', '0', '1', '16', '你有额头油脂分泌多的现象吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('17', '0', '1', '17', '你面色晦暗或容易出现褐斑吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('18', '0', '1', '18', '你容易过敏吗？（对药物、食物、气味、花粉或在季节交替、气候变化时）', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('19', '0', '1', '19', '你容易感到害怕或受到惊吓吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('20', '0', '1', '20', '你容易疲乏吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('21', '0', '1', '21', '你胁肋部或乳房胀痛吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('22', '0', '1', '22', '你不感冒也会鼻塞、流鼻涕吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('23', '0', '1', '23', '你嘴里有黏黏的感觉吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('24', '0', '1', '24', '你容易气短吗？（呼吸短促、接不上气）', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('25', '0', '1', '25', '你感觉身体、脸上发热吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('26', '0', '1', '26', '你的口唇颜色比一般人红吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('27', '0', '1', '27', '你上眼脸比别人肿吗（上眼脸有轻微隆起现象）？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('28', '0', '1', '28', '你带下色黄（白带颜色发黄）吗？女性\r\n你的阴囊部位潮湿吗？男性', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('29', '0', '1', '29', '你多愁善感，感情脆弱吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('30', '0', '1', '30', '你有因季节变化、温度变化或异味等原因而哮喘的现象吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('31', '0', '1', '31', '你感到身体沉重不轻松或不爽快吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('32', '0', '1', '32', '你大便有粘滞不爽、有解不尽的感觉吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('33', '0', '1', '33', '你平时痰多，特别是咽喉部总感到有痰堵着吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('34', '0', '1', '34', '你容易心慌吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('35', '0', '1', '35', '你容易头晕或者站起时眩晕吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('36', '0', '1', '36', '你能适应外界自然和社会环境的变化吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('37', '0', '1', '37', '你吃/喝凉的东西会感觉不舒服或者怕吃/喝凉的东西吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('38', '0', '1', '38', '你容易便秘或大便干燥吗？', '无', '很少 ', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('39', '0', '1', '39', '你容易生痤疮或疮疖吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('40', '0', '1', '40', '你两颧部有细微红丝吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('41', '0', '1', '41', '你咽喉部有异物感，且吐之不出、咽之不下吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('42', '0', '1', '42', '你的皮肤容易起荨麻疹（风团、风疹块、风疙瘩）吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('43', '0', '1', '43', '你比一般人耐受不了寒冷（冬天的寒冷、夏天的冷空调、电扇等）吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('44', '0', '1', '44', '你活动量稍大就容易出虚汗吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('45', '0', '1', '45', '你感到手心脚心发热吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('46', '0', '1', '46', '你小便时尿道有发热感、尿色浓（深）吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('47', '0', '1', '47', '你身体有哪里疼痛吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('48', '0', '1', '48', '你不感冒也会打喷嚏吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('49', '0', '1', '49', '你舌苔厚腻或有舌苔厚厚的感觉吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('50', '0', '1', '50', '你的皮肤在不知不觉中会出现青紫瘀斑（皮下出血）吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('51', '0', '1', '51', '你容易精神紧张、焦虑不安吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('52', '0', '1', '52', '你受凉或吃喝凉的东西后，容易腹泻（拉肚子）吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('53', '0', '1', '53', '你感到胸闷或腹部胀满吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('54', '0', '1', '54', '你容易忘事（健忘）吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('55', '0', '1', '55', '你面部或鼻部有油腻感或者油亮发光吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('56', '0', '1', '56', '你喜欢安静、懒得说话吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('57', '0', '1', '57', '你口唇颜色偏暗吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('58', '0', '1', '58', '你的皮肤因过敏出现过紫癜（紫红色瘀点、瘀斑）吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('59', '0', '1', '59', '你手脚发凉吗？', '无', '很少', '有时', '经常', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('60', '0', '1', '60', '你面部两颧潮红或偏红吗？', '无', '很少', '有时', '有时', '总是', null, null);
INSERT INTO `shi_ti` VALUES ('61', '0', '2', '1', '焦虑心境（anxious mood）：担心、担忧，感到有最坏的事将要发生，容易激惹。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('62', '0', '2', '2', '紧张（tension）：紧张感、易疲劳、不能放松、情绪反应，易哭、颤抖、感到不安。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('63', '0', '2', '3', '害怕（fears）：害怕黑暗、陌生人、一人独处、动物、乘车或旅行及人多的场合。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('64', '0', '2', '4', '失眠（insomnia）：难以入睡、易醒、睡得不深、多梦、夜惊、醒后感疲倦。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('65', '0', '2', '5', '认知功能（cognitive）：或称记忆、注意障碍，注意力不能集中，记忆力差。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('66', '0', '2', '6', '抑郁心境（depressed mood）：丧失兴趣、对以往爱好缺乏快感、抑郁、早醒、昼重夜轻。 ', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('67', '0', '2', '7', '躯体性焦虑：肌肉系统（somatic ansiety：muscuolar）：肌肉酸痛、活动不灵活、肌肉抽动、肢体抽动、牙齿打颤、声音发抖。 ', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('68', '0', '2', '8', '躯体性焦虑：感觉系统（Somatic anxiety：sensory）：视物模糊、发冷发热、软弱无力感、浑身刺痛。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('69', '0', '2', '9', '心血管系统症状（cardiovascular-symptoms）：心动过速、心悸、胸痛、心管跳动感、昏倒感、心搏脱漏。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('70', '0', '2', '10', '10．呼吸系统症状（respiratory symptoms）：胸闷、窒息感、叹息、呼吸困难。 ', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('71', '0', '2', '11', '11．胃肠道症状（gastro-intestinal symptoms）：吞咽困难、嗳气、消化不良（进食后腹痛、\r\n腹胀、恶心、胃部饱感）、肠动感、肠鸣、腹泻、体重减轻、便秘。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('72', '0', '2', '12', '生殖泌尿神经系统症状（genito-urinary symptoms）：尿意频数、尿急、停经、性冷淡、早泄、阳萎。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('73', '0', '2', '13', '植物神经系统症状（autonomic symptoms）：口干、潮红、苍白、易出汗、起鸡皮疙瘩、\r\n紧张性头痛、毛发竖起。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('74', '0', '2', '14', '会谈时行为表现（behavior at interview）：（1）一般表现：紧张、不能松驰、忐忑不安，咬手指、紧紧握拳、摸弄手帕，面肌抽动、不宁顿足、手发抖、皱眉、表情僵硬、肌张力高，叹气样呼吸、面色苍白。（2）生理表现：吞咽、打呃、安静时心率快、呼吸快（20次/分以上）、腱反射亢进、震颤、瞳孔放大、眼睑跳动、易出汗、眼球突出。', '无症状', '轻', '中等', '重', '极重', null, null);
INSERT INTO `shi_ti` VALUES ('75', '0', '3', '1', '抑郁情绪', '无症状；', '只有在问到时才诉述；', '在访谈中自发地表达；', '不用言语也可以从表情、姿势、声音或欲哭中流露出这种情绪；', '病人的言语和非言语表达（表情、动作）几乎完全表现为这种情绪。', null, null);
INSERT INTO `shi_ti` VALUES ('76', '0', '3', '2', '有罪感', '无症状；', '责备自己，感到自己已连累他人；', '认为自己犯了罪，或反复思考以往的过失或错误；', '认为目前的疾病是对自己错误的惩罚，或有罪恶妄想；', '罪恶妄想伴有指责或威胁性幻觉。', null, null);
INSERT INTO `shi_ti` VALUES ('77', '0', '3', '3', '自杀 ', '无症状；', '觉得活着没有意义；', '希望自己已经死去，或常想到与死有关的事；', '消极观念（自杀念头）；', '消极观念（自杀念头）。', null, null);
INSERT INTO `shi_ti` VALUES ('78', '0', '3', '4', '入睡困难 ', '无症状；', '主诉有入睡困难，即上床后半小时仍不能入睡；', '主诉每晚均有入睡困难。', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('79', '0', '3', '5', '睡眠不深', '无症状；', '睡眠浅，多恶梦；', '半夜（晚12点以前）曾醒来（不包括上厕所）。', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('80', '0', '3', '6', '早醒 ', '无症状；', '有早醒，比平时早醒1小时，但能重新入睡(应排除平日的习惯)；', '早醒后无法重新入睡。', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('81', '0', '3', '7', '工作和兴趣', '无症状；', '提问时才诉述；', '自发地直接或间接表达对活动、工作或学习失去兴趣，如感到无精打采、犹豫不决、不能坚持或需强迫才能工作或活动；', '活动时间减少或效率降低，住院患者每天参加病室劳动或娱乐不满3小时；', '因目前的疾病而停止工作，住院者不参加任何活动或者没有他人帮助便不能完成病室日常事务。', null, null);
INSERT INTO `shi_ti` VALUES ('82', '0', '3', '8', '迟滞（指思维和言语缓慢，注意力难以集中，主动性减退） ', '无症状；', '精神检查中发现轻度迟滞；', '精神检查中发现明显迟缓；', '精神检查进行困难；', '完全不能回答问题（木僵）。', null, null);
INSERT INTO `shi_ti` VALUES ('83', '0', '3', '9', '激越', '无症状：', '检查时表现得有些心神不定；', '明显的心神不定或小动作多；', '不能静坐，检查中曾起立；', '搓手、咬手指、扯头发、咬嘴唇。', null, null);
INSERT INTO `shi_ti` VALUES ('84', '0', '3', '10', '精神性焦虑', '无症状；', '问及时诉述；', '自发地表达；', '表情和言语流露出明显焦虑；', '明显惊恐。', null, null);
INSERT INTO `shi_ti` VALUES ('85', '0', '3', '11', '躯体性焦虑（指焦虑的生理症状，包括口干、腹胀、腹泻、打嗝、腹绞痛、心悸、头痛、过度换气和叹息，以及尿频和出汗等）', '无症状；', '轻度；', '中度，有肯定的上述症状；', '重度，上述症状严重，影响生活，需加处理；', '严重影响生活和活动。', null, null);
INSERT INTO `shi_ti` VALUES ('86', '0', '3', '12', '胃肠道症状', '无症状；', '食欲减退，但不需要他人鼓励便自行进食；', '进食需他人催促或请求和需要应用泻药或助消化药。', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('87', '0', '3', '13', '全身症状 ', '无症状；', '四肢、背部或颈部沉重感，背痛、头痛、肌肉疼痛，全身乏力或疲倦；', '症状明显。', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('88', '0', '3', '14', '（性症状（指性欲减退，月经紊乱等）', '无症状；', '轻度；', '重度；', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('89', '0', '3', '15', '疑病', '无症状；', '对身体过分关注；', '反复考虑健康问题；', '有疑病妄想；', '伴幻觉的疑病妄想。', null, null);
INSERT INTO `shi_ti` VALUES ('90', '0', '3', '16', '体重减轻', '没有；', '可能有体重减轻，或一周内体重减轻超过0.5公斤；', '肯定体重减轻，或一周内体重减轻超过1公斤（根据病史或医生测定体重评定）。', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('91', '0', '3', '17', '自知力', '知道自己有病，表现为抑郁；', '知道自己有病，但归咎于伙食太差、环境问题、工作过忙、病毒感染、需要休息等；', '完全否认有病。', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('92', '0', '3', '18', '日夜变化', '无；', '轻度变化；', '重度变化。', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('93', '0', '3', '19', '人格或现实解体', '无；', '问及才诉述；', '自然诉述；', '有虚无妄想；', '伴幻觉的虚无妄想。', null, null);
INSERT INTO `shi_ti` VALUES ('94', '0', '3', '20', '偏执症状', '无；', '有猜疑；', '有牵连观念；', '有关系妄想或被害妄想；', '伴有 关系妄想或被害妄想。', null, null);
INSERT INTO `shi_ti` VALUES ('95', '0', '3', '21', '强迫症状', '无；', '问及时才诉述；', '自发诉述。', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('96', '0', '3', '22', '能力减退感', '无；', '仅于提问时方引出主观体验；', '病人主动表示有能力减退感；', '需鼓励指导和安慰才能完成病室日常事务或个人卫生；', '穿衣、梳洗、进食、铺床或个人卫生均需要他人协助；', null, null);
INSERT INTO `shi_ti` VALUES ('97', '0', '3', '23', '绝望感', '无；', '有时怀疑“情况是否会好转”，但解释后能接受；', '持续感到“没有希望”，但解释后能接受；', '对未来感到灰心、悲观和绝望，解释后不能排除；', '自动反复诉述“我的病不会好了”或诸如此类的情况。', null, null);
INSERT INTO `shi_ti` VALUES ('98', '0', '3', '24', '自卑感', '无；', '仅在询问时诉述有自卑感；', '自动诉述有自卑感（我不如他人）；', '病人主动诉述“我一无是处”或“低人一等”，与评2分者只是程度的差别；', '自卑感达妄想的程度，例如“我是废物”或类似情况。', null, null);
INSERT INTO `shi_ti` VALUES ('99', '0', '4', '1', '喉咙异物感或吞咽困难；', '从无', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('100', '0', '4', '2', '疼痛；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('101', '0', '4', '3', '医学实验室辅助检查；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('102', '0', '4', '4', '有明确诊断的疾病；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('103', '0', '4', '5', '多汗；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('104', '0', '4', '6', '医生查体的阳性体征；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('105', '0', '4', '7', '全身或肢体乏力或易疲劳；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('106', '0', '4', '8', '憋气；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('107', '0', '4', '9', '肌肉跳动感；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('108', '0', '4', '10', '肉眼可见的损害；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('109', '0', '4', '11', '体验到症状的性质及部位相\r\n对固定，症状清晰、生动；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('110', '0', '4', '12', '患者主观不适体验；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('111', '0', '4', '13', '手足发冷或发热；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('112', '0', '4', '14', '脑鸣或耳鸣；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('113', '0', '4', '15', '健忘；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('114', '0', '4', '16', '不能集中注意力；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('115', '0', '4', '17', '不能快速思考或脑子一片空白；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('116', '0', '4', '18', '类似幻觉的症状；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('117', '0', '4', '19', '认为自己的身体出现了严重问题；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('118', '0', '4', '20', '体验到的躯体不适感在身体各部分游走；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('119', '0', '4', '21', '很容易体验到躯体的各种不适；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('120', '0', '4', '22', '有许多不同类型的症状搅扰您；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('121', '0', '4', '23', '有许多不同类型的症状搅扰您；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('122', '0', '4', '24', '心前区不适；', '从不', '轻度', '中度', '偏重 ', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('123', '0', '4', '25', '短暂神志不清；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('124', '0', '4', '26', '头晕或眩晕；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('125', '0', '4', '27', '感觉躯体某部位丧失功能；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('126', '0', '4', '28', '感觉自己缺氧；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('127', '0', '4', '29', '全身或局部肿胀感；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('128', '0', '4', '30', '入睡困难；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('129', '0', '4', '31', '睡眠浅；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('130', '0', '4', '32', '早醒；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('131', '0', '4', '33', '醒后易疲倦；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('132', '0', '4', '34', '多梦；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('133', '0', '4', '35', '尿频；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('134', '0', '4', '36', '感到自己的精力下降，活动减慢；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('136', '0', '4', '37', '性欲减退；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('137', '0', '4', '38', '消化不良；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('138', '0', '4', '39', '皮肤过敏；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('139', '0', '4', '40', '便秘；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('140', '0', '4', '41', '胃肠胀气；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('141', '0', '4', '42', '溃疡；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('142', '0', '4', '43', '做事提不起兴趣；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('143', '0', '4', '44', '上腹烧灼感；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('144', '0', '4', '45', '头部沉重感或紧束感；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('145', '0', '4', '46', '腹泻；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('146', '0', '4', '47', '恶心或呕吐；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('147', '0', '4', '48', '鼻腔异物感；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('148', '0', '4', '49', '心慌或心悸;', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('149', '0', '4', '50', '一阵阵坐立不安心神不定;', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('150', '0', '4', '51', '感到熟悉的东西变得陌生或不像真的（非真实感）;', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('151', '0', '4', '52', '您比别人对疼痛更敏感;', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('152', '0', '4', '53', '您体验到的躯体症状内容具有多样性、多变性；', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('153', '0', '4', '54', '您比大多数人更担心自己的健康;', '从不', '轻度', '中度', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('154', '0', '4', '55', '如果某种疾病引起您的注意，如通过广播、电视、报纸或您认识的人那看到、听到，您担心自己患这种病；', '从不', '轻度', '中度', '偏重', ' 严重', null, null);
INSERT INTO `shi_ti` VALUES ('155', '0', '5', '1', '头痛', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('156', '0', '5', '2', '神经过敏，心中不踏实。 ', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('157', '0', '5', '3', '头脑中有不必要的想法或字句盘旋。  ', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('158', '0', '5', '4', '头昏或昏倒。', '没有', '很轻', '中等', '偏重 ', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('159', '0', '5', '5', '对异性的兴趣减退。', '没有', '很轻', '中等', '偏重', ' 严重', null, null);
INSERT INTO `shi_ti` VALUES ('160', '0', '5', '6', '对旁人责备求全。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('161', '0', '5', '7', '感到别人能控制您的思想。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('162', '0', '5', '8', '责怪别人制造麻烦。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('163', '0', '5', '9', '忘记性大。 ', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('164', '0', '5', '10', '担心自己的衣饰整齐及仪态的端正。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('165', '0', '5', '11', '容易烦恼和激动。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('166', '0', '5', '12', '胸痛。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('167', '0', '5', '13', '害怕空旷的场所或街道。', '没有', '很轻', '中等', '偏重', '严重 ', null, null);
INSERT INTO `shi_ti` VALUES ('168', '0', '5', '14', '感到自己的精力下降，活动减慢。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('169', '0', '5', '15', '想结束自己的生命。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('170', '0', '5', '16', '听到旁人听不到的声音。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('171', '0', '5', '17', '发抖。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('172', '0', '5', '18', '感到大多数人都不可信任。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('173', '0', '5', '19', '胃口不好。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('174', '0', '5', '20', '容易哭泣。 ', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('175', '0', '5', '21', '同异性相处时感到害羞不自在。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('176', '0', '5', '22', '感到受骗，中了圈套或有人想抓住您。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('177', '0', '5', '23', '无缘无故地突然感到害怕。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('178', '0', '5', '24', '自己不能控制地大发脾气。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('179', '0', '5', '25', '怕单独出门。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('180', '0', '5', '26', '经常责怪自己。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('181', '0', '5', '27', '腰痛。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('182', '0', '5', '28', '感到难以完成任务。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('183', '0', '5', '29', '感到孤独。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('184', '0', '5', '30', '感到苦闷。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('185', '0', '5', '31', '过分担忧。', '没有', ' 很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('186', '0', '5', '32', '对事物不感兴趣。', '没有', ' 很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('187', '0', '5', '33', '感到害怕。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('188', '0', '5', '34', '您的感情容易受到伤害。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('189', '0', '5', '35', '旁人能知道您的私下想法。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('190', '0', '5', '36', '感到别人不理解您、不同情您。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('191', '0', '5', '37', '感到人们对您不友好，不喜欢您。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('192', '0', '5', '38', '做事必须做得很慢以保证做得正确。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('193', '0', '5', '39', '心跳得很厉害。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('194', '0', '5', '40', '恶心或胃部不舒服。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('195', '0', '5', '41', '恶心或胃部不舒服。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('196', '0', '5', '42', '肌肉酸痛。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('197', '0', '5', '43', '感到有人在监视您、谈论您。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('198', '0', '5', '44', '难以入睡。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('199', '0', '5', '45', '做事必须反复检查。', '没有 ', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('200', '0', '5', '46', '难以作出决定。', '没有', '很轻 ', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('201', '0', '5', '47', '难以作出决定。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('202', '0', '5', '48', '呼吸有困难。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('203', '0', '5', '49', '一阵阵发冷或发热。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('204', '0', '5', '50', '因为感到害怕而避开某些东西、场合或活动。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('205', '0', '5', '51', '脑子变空了。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('206', '0', '5', '52', '身体发麻或刺痛。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('207', '0', '5', '53', '喉咙有梗塞感。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('208', '0', '5', '54', '感到前途没有希望。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('209', '0', '5', '55', '不能集中注意。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('210', '0', '5', '56', '感到身体的某一部分软弱无力。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('211', '0', '5', '57', '感到紧张或容易紧张。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('212', '0', '5', '58', '感到手或脚发重。', '没有', '很轻 ', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('213', '0', '5', '59', '想到死亡的事。 ', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('214', '0', '5', '60', '吃得太多。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('215', '0', '5', '61', '当别人看着您或谈论您时感到不自在。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('216', '0', '5', '62', '有一些不属于您自己的想法。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('217', '0', '5', '63', '有想打人或伤害他人的冲动。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('218', '0', '5', '64', '醒得太早。 ', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('219', '0', '5', '65', '必须反复洗手、点数目或触摸某些东西。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('220', '0', '5', '66', '睡得不稳不深。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('221', '0', '5', '67', '有想摔坏或破坏东西的冲动。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('222', '0', '5', '68', '有一些别人没有的想法或念头。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('223', '0', '5', '69', '感到对别人神经过敏。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('224', '0', '5', '70', '在商店或电影院等人多的地方感到不自在。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('225', '0', '5', '71', '感到任何事情都很困难。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('226', '0', '5', '72', '一阵阵恐惧或惊恐。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('227', '0', '5', '73', '感到在公共场合吃东西很不舒服。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('228', '0', '5', '74', '经常与人争论。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('229', '0', '5', '75', '单独一个人时神经很紧张。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('230', '0', '5', '76', '别人对您的成绩没有作出恰当的评价。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('231', '0', '5', '77', '即使和别人在一起也感到孤单。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('232', '0', '5', '78', '感到坐立不安心神不定。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('233', '0', '5', '79', '感到自己没有什么价值。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('234', '0', '5', '80', '感到熟悉的东西变成陌生或不象是真的。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('235', '0', '5', '81', '大叫或摔东西。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('236', '0', '5', '82', '害怕会在公共场合昏倒。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('237', '0', '5', '83', '感到别人想占您的便宜。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('238', '0', '5', '84', '为一些有关性的想法而很苦恼。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('239', '0', '5', '85', '您认为应该因为自己的过错而受到惩罚。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('240', '0', '5', '86', '感到要很快把事情做完。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('241', '0', '5', '87', '感到自己的身体有严重问题。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('242', '0', '5', '88', '从未感到和其他人很亲近。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('243', '0', '5', '89', '感到自己有罪。', '没有', '很轻', '中等', '偏重', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('244', '0', '5', '90', '感到自己的脑子有毛病。', '没有', '很轻', '中等', '中等', '严重', null, null);
INSERT INTO `shi_ti` VALUES ('254', '0', '6', '1', '你是否有许多不同的业余爱好？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('255', '0', '6', '2', '你是否在做任何事情以前都要停下来仔细思考？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('256', '0', '6', '3', '你的心境是否常有起伏？ ', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('257', '0', '6', '4', '你曾有过明知是别人的功劳而你去接受奖励的事吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('258', '0', '6', '5', '你是否健谈？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('259', '0', '6', '6', '欠债会使你不安吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('260', '0', '6', '7', '你曾无缘无故觉得\"真是难受\"吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('261', '0', '6', '8', '你曾经贪图过份外之物吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('262', '0', '6', '9', '你是否在晚上小心翼翼地关好门窗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('263', '0', '6', '10', '你是否比较活跃？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('264', '0', '6', '11', '你在见到一小孩或一动物受折磨时是否会感到非常难过？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('265', '0', '6', '12', '你是否常常为自己不该做而做了的事，不该说而说了的话而紧张吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('266', '0', '6', '13', '你喜欢跳降落伞吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('267', '0', '6', '14', '通常你能在热闹联欢会中尽情地玩吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('268', '0', '6', '15', '你容易激动吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('269', '0', '6', '16', '你曾经将自己的过错推给别人吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('270', '0', '6', '17', '你喜欢会见陌生人吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('271', '0', '6', '18', '你喜欢会见陌生人吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('272', '0', '6', '19', '你是一个容易伤感情的人吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('273', '0', '6', '20', '你所有的习惯都是好的吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('274', '0', '6', '21', '在社交场合你是否总不愿露头角？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('275', '0', '6', '22', '你会服用有奇异或危险作用的药物吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('276', '0', '6', '23', '你常有\"厌倦\"之感吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('277', '0', '6', '24', '你曾拿过别人的东西（哪怕是一针一线）吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('278', '0', '6', '25', '你是否常爱外出？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('279', '0', '6', '26', '你是否从伤害你所宠爱的人而感到乐趣？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('280', '0', '6', '27', '你常为有罪恶之感所苦恼吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('281', '0', '6', '28', '你在谈论中是否有时不懂装懂？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('282', '0', '6', '29', '你是否宁愿去看些书而不愿去多见人？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('283', '0', '6', '30', '你有要伤害你的仇人吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('284', '0', '6', '31', '你觉得自己是一个神经过敏的人吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('285', '0', '6', '32', '对人有所失礼时你是否经常要表示歉意？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('286', '0', '6', '33', '你有许多朋友吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('287', '0', '6', '34', '你是否喜爱讲些有时确能伤害人的笑话？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('288', '0', '6', '35', '你是一个多忧多虑的人吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('289', '0', '6', '36', '你在童年是否按照吩咐要做什么便做什么，毫无怨言？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('290', '0', '6', '37', '你认为你是一个乐天派吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('291', '0', '6', '38', '你很讲究礼貌和整洁吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('292', '0', '6', '39', '你是否总在担心会发生可怕的事情？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('293', '0', '6', '40', '你是否总在担心会发生可怕的事情？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('294', '0', '6', '41', '交新朋友时一般是你采取主动吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('295', '0', '6', '42', '当别人向你诉苦时，你是否容易理解他们的苦衷？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('296', '0', '6', '43', '你认为自己很紧张，如同\"拉紧的弦\"一样吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('297', '0', '6', '44', '在没有废纸篓时，你是否将废纸扔在地板上？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('298', '0', '6', '45', '当你与别人在一起时，你是否言语很少？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('299', '0', '6', '46', '你是否认为结婚制度是过时了，应该废止？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('300', '0', '6', '47', '你是否有时感到自己可怜？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('301', '0', '6', '48', '你是否有时有点自夸？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('302', '0', '6', '49', '你是否很容易将一个沉寂的集会搞得活跃起来？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('303', '0', '6', '50', '你是否讨厌那种小心翼翼地开车的人？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('304', '0', '6', '51', '你为你的健康担忧吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('305', '0', '6', '52', '你曾讲过什么人的坏话吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('306', '0', '6', '53', '你是否喜欢对朋友讲笑话和有趣的故事？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('307', '0', '6', '54', '你小时曾对父母粗暴无礼吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('308', '0', '6', '55', '你是否喜欢与人混在一起？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('309', '0', '6', '56', '你如知道自己工作有错误，这会使你感到难过吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('310', '0', '6', '57', '你患失眠吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('311', '0', '6', '58', '你吃饭前必定洗手吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('312', '0', '6', '59', '你常无缘无故感到无精打采和倦怠吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('313', '0', '6', '60', '和别人玩游戏时，你有过欺骗行为吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('314', '0', '6', '61', '你是否喜欢从事一些动作迅速的工作？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('315', '0', '6', '62', '你的母亲是一位善良的妇人吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('316', '0', '6', '63', '你是否常常觉得人生非常无味？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('317', '0', '6', '64', '你曾利用过某人为自己取得好处吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('318', '0', '6', '65', '你是否常常参加许多活动，超过你的时间所允许？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('319', '0', '6', '66', '是否有几个人总在躲避你？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('320', '0', '6', '67', '你是否为你的容貌而非常烦恼？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('321', '0', '6', '68', '你是否觉得人们为了未来有保障而办理储蓄和保险所花的时间太多？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('322', '0', '6', '69', '你曾有过不如死了为好的愿望吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('323', '0', '6', '70', '如果有把握永远不会被人发现，你会逃税吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('324', '0', '6', '71', '你能使一个集会顺利进行吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('325', '0', '6', '72', '你能克制自己不对人无礼吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('326', '0', '6', '73', '遇到一次难堪的经历以后，你是否在一段长时间内还感到难受？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('327', '0', '6', '74', '你患有\"神经过敏\"吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('328', '0', '6', '75', '你曾经故意说些什么来伤害别人的感情吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('329', '0', '6', '76', '你与别人的友谊是否容易破裂，虽然不是你的过错？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('330', '0', '6', '77', '你常感到孤单吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('331', '0', '6', '78', '当人家寻你的差错，找你工作中的缺点时，你是否容易在精神上受挫伤？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('332', '0', '6', '79', '你赴约会或上班曾迟到过吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('333', '0', '6', '80', '你喜欢忙忙碌碌和热热闹闹过日子吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('334', '0', '6', '81', '你愿意别人怕你吗？ ', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('335', '0', '6', '82', '你是否觉得有时浑身是劲，而有时又是懒洋洋的吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('336', '0', '6', '83', '你有时把今天应做的事拖到明天去做吗？ ', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('337', '0', '6', '84', '别人认为你是生气勃勃的吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('338', '0', '6', '85', '别人是否对你说了许多谎话？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('339', '0', '6', '86', '你是否对某些事物容易冒火？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('340', '0', '6', '87', '当你犯了错误时，你是否常常愿意承认它？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('341', '0', '6', '88', '你会为一动物落入圈套被捉拿而感到很难过吗？', '是', '否', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('342', '0', '7', '1', '关心躯体健康：指对自身健康的过分关心，不考虑其主诉有无客观基础。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('343', '0', '7', '2', '焦虑：指精神性焦虑，即对当前及未来情况的担心，恐惧或过分关注。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('344', '0', '7', '3', '情感交流障碍：指与检查者之间如同存在无形隔膜，无法实现正常的情感交流。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('345', '0', '7', '4', '概念紊乱：指联想散漫、零乱和解体的程度。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('346', '0', '7', '5', '罪恶观念：指对以往言行的过分关心内疚和悔恨。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('347', '0', '7', '6', '紧张：指焦虑性运动表现。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('348', '0', '7', '7', '装相和作态：指不寻常的或不自然的运动性行为。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('349', '0', '7', '8', '夸大：即过分自负，确信具有不寻常的才能和权力等。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('350', '0', '7', '9', '心境抑郁：即心境不佳、悲伤、沮丧或情绪低落的程度。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('351', '0', '7', '10', '敌对性：指对他人（不包括检查者）的仇恨、敌对和蔑视。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('352', '0', '7', '11', '猜疑：指检查当时认为有人正在或曾经来意地对待他。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('353', '0', '7', '12', '幻觉：指没有相应外界刺激的感知。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('354', '0', '7', '13', '动作迟缓：指言语、动作和行为的减少和缓慢。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('355', '0', '7', '14', '不合作：指会谈时对检查者的对立、不友好、不满意或不合作。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('356', '0', '7', '15', '不寻常思维内容：即荒谬古怪的思维内容。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('357', '0', '7', '16', '情感平淡：指情感基调低，明显缺乏相应的正常情感反应。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('358', '0', '7', '17', '兴奋：指情感基调增高，激动，对外界反应增强。', '无症状', '可疑或很轻', '轻度', '中度', '偏重 ', null, null);
INSERT INTO `shi_ti` VALUES ('359', '0', '7', '18', '定向障碍：指对人物、地点或时间分辨不清。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('360', '0', '7', '19', '自知力障碍：指对自身精神疾病、精神症状或不正常言行缺乏认识。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('361', '0', '7', '20', '工作不能：指对日常工作或活动的影响。', '无症状', '可疑或很轻', '轻度', '中度', '偏重', null, null);
INSERT INTO `shi_ti` VALUES ('364', '0', '8', '1', '动作', '无该项症状或与患者正常时的水平相仿', '动作稍多，表情活跃 ', '动作多，姿势活跃', '动作极多，会谈时曾起立活动', '动个不停，虽予劝说仍坐立不安宁', null, null);
INSERT INTO `shi_ti` VALUES ('365', '0', '8', '2', '语言', '无该项症状或与患者正常时的水平相仿', '话较多', '话多，几无自动停顿', '很难打断', '无法打断', null, null);
INSERT INTO `shi_ti` VALUES ('366', '0', '8', '3', '意念飘忽', '无该项症状或与患者正常时的水平相仿', '描述、修饰或解释的词句过多', '内容稍散漫或离题，有意联，音联或双关语', '思维散漫无序', '思维不连贯，内容无法理解 ', null, null);
INSERT INTO `shi_ti` VALUES ('367', '0', '8', '4', '语言/喧闹程度', '无该项症状或与患者正常时的水平相仿', '说话声音高', '大声说话，隔开一段距离仍能听到 ', '语音极高夹带歌声或躁音', '呼喊或尖叫', null, null);
INSERT INTO `shi_ti` VALUES ('368', '0', '8', '5', '敌意/破坏行为', '无该项症状或与患者正常时的水平相仿', '稍急躁或易激惹，能控制', '明显急躁，易激惹或易怒', '有威胁性行为，但能被安抚', '狂暴，冲动或破坏行为', null, null);
INSERT INTO `shi_ti` VALUES ('369', '0', '8', '6', '情绪', '无该项症状或与患者正常时的水平相仿', '略高涨，乐观 ', '高涨，爱开玩笑，易笑', '明显高涨，洋洋自得', '极高涨，和环境不协调', null, null);
INSERT INTO `shi_ti` VALUES ('370', '0', '8', '7', '自我评价  ', '无该项症状或与患者正常时的水平相仿 ', '略高', '高，常自诩自夸', '有不合实际的夸大观念', '有难以纠正的夸大妄想', null, null);
INSERT INTO `shi_ti` VALUES ('371', '0', '8', '8', '接触', '无该项症状或与患者正常时的水平相仿', '稍有爱管闲事或指手划脚倾向', '爱管闲事，好争辩', '爱发号施令，指挥他人', '专横，与环境不协调', null, null);
INSERT INTO `shi_ti` VALUES ('372', '0', '8', '9', '睡眠', '无该项症状或与患者正常时的水平相仿', '睡眠时间减少25% ', '睡眠时间减少50%', '睡眠时间减少75% ', '整夜不眠', null, null);
INSERT INTO `shi_ti` VALUES ('373', '0', '8', '10', '性兴趣', '无该项症状或与患者正常时的水平相仿', '兴趣稍增强，有些轻浮言行', '性兴趣增强，有明显轻浮言行', '性兴趣显著增强，有严重调戏异性，或卖弄风情言行', '整日专注于性活动', null, null);
INSERT INTO `shi_ti` VALUES ('374', '0', '8', '11', '工作 ', '无该项症状或与患者正常时的水平相仿', '工作质量略有下降', '工作质量明显下降', '无法继续工作，或在医院内尚能参加活动数小时', '日常活动不能自理，或不能参加病房活动', null, null);
INSERT INTO `shi_ti` VALUES ('375', '0', '8', '12', '幻觉 ', '无该项症状或与患者正常时的水平相仿', '偶有或可疑', '肯定存在，每天≥3次', '经常出现', '行为受幻觉支配', null, null);
INSERT INTO `shi_ti` VALUES ('376', '0', '8', '13', '妄想（不包括夸大妄想）', '无该项症状或与患者正常时的水平相仿', '偶有或可疑', '妄想肯定，可用情绪解释', '妄想肯定，难以用情绪解释', '出现幻觉的妄想', null, null);
INSERT INTO `shi_ti` VALUES ('377', '0', '9', '1', '文化程度', '文盲（未受过教育）', '小学（教育年限小于等6年）', '中学或以上（教育年限大于6年）', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('378', '0', '9', '2', '现在是哪一年', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('379', '0', '9', '3', '现在是几月份', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('380', '0', '9', '4', '现在是几日 ', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('381', '0', '9', '5', '现在是星期几', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('382', '0', '9', '6', '这里是什么市（省）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('383', '0', '9', '7', '这里是什么区（县）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('384', '0', '9', '8', '这里是什么街道（乡、镇）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('385', '0', '9', '9', '这里是什么路（村）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('386', '0', '9', '10', '取出五分硬币，请说出其名称', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('387', '0', '9', '11', '取出钢笔套，请说出其名称 ', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('388', '0', '9', '12', '取出钥匙圈，请说出其名称', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('389', '0', '9', '13', '移去物品，问“刚才您看过哪些东西”（五分硬币）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('390', '0', '9', '14', '移去物品，问“刚才您看过哪些东西”（钢笔套）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('391', '0', '9', '15', '移去物品，问“刚才您看过哪些东西”（钥匙圈）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('392', '0', '9', '16', '一元钱用去7分，还剩多少', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('393', '0', '9', '17', '再加7分，等于多少', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('394', '0', '9', '18', '再加7分，等于多少', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('395', '0', '9', '19', '请您用右手拿纸（取）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('396', '0', '9', '20', '请将纸对折（折）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('397', '0', '9', '21', '请把纸放在桌子上（放）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('398', '0', '9', '22', '请再想一下，让您看过什么东西（五分硬币）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('399', '0', '9', '23', '请再想一下，让您看过什么东西（钢笔套）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('400', '0', '9', '24', '请再想一下，让您看过什么东西（钥匙圈）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('401', '0', '9', '25', '取出图片（孙中山或其他名人），问“请看这是谁的像片？”', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('402', '0', '9', '26', '取出图片（毛泽东或其他名人），问“请看这是谁的像片？”', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('403', '0', '9', '27', '取出图片，让被试者说出图的主题（送伞）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('404', '0', '9', '28', '取出图片，让被试者说出图的主题（买油）', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('405', '0', '9', '29', '我国的总理是谁', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('406', '0', '9', '30', '一年有多少天 ', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('407', '0', '9', '31', '新中国是那一年成立的', '正确', '错误', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('409', '0', '10', '1', '今天是几月？几日？星期几？', '0', '3', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('410', '0', '10', '2', '这是什么地方？', '0', '2.5', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('411', '0', '10', '3', '你多大哪年龄 ？', '0', '2', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('412', '0', '10', '4', '最近发生的事情 [ 如早（午）饭吃的什么？', '0', '2.5', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('413', '0', '10', '5', '你是什么地方出生的？ ', '0', '2', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('414', '0', '10', '6', '中华人民共和国（新中国）何时成立的？（年、月、日）', '0', '3.5', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('415', '0', '10', '7', '一年有多少天？（或一小时有多少分钟？）', '0', '2.5', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('416', '0', '10', '8', '中华人民共和国总理是谁？', '0', '3', null, null, null, null, null);
INSERT INTO `shi_ti` VALUES ('417', '0', '10', '9', '100-7=？，93-7=？', '0', '2', '4', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('418', '0', '10', '10', '倒说数字6-8-2，3-5-2-9', '0', '2', '4', null, null, null, null);
INSERT INTO `shi_ti` VALUES ('419', '0', '10', '11', '五个物品（硬币、钥匙、手机、手表、笔、矿泉水、扑克牌、手电筒），\r\n让其一个个看过后，收起，问都有什么东西？', '0', '0.5', '1.5', '2.5', '3.5', null, null);
INSERT INTO `shi_ti` VALUES ('420', '0', '11', '1', '面部表情变化少 \r\n面部表情呆板、机械、冷漠、情绪不随谈话内容而变化或变化少。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('421', '0', '11', '2', '自发动作少\r\n在整个交谈过程中静坐着，很少或完全没有自发动作，坐位、姿势或手足都很少变动。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('422', '0', '11', '3', '姿势表情贫乏\r\n在表达自己的思想时不借助手势或躯体的位置变换。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('423', '0', '11', '4', '眼神接触差\r\n避免与他人目光接触，也不用眼神以辅助表情。即使在讲话时眼睛也茫然凝视前方。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('424', '0', '11', '5', '无情感反应\r\n在说笑话或开玩笑时都不能引出笑容。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('425', '0', '11', '6', '语调缺乏波动\r\n语声常很单调，缺乏正常的抑扬顿挫，不用音调或音量的变化来强调重要的词汇', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('426', '0', '11', '7', '情感平淡总评\r\n全面评定症状的严重性。重点在于无反应、不适切、以及情感强度的全面减低。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('427', '0', '11', '8', '语量贫乏\r\n自发言语的语量有限，因而在回答问题时往往很简单，很肤浅，没有发挥。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('428', '0', '11', '9', '言语内容贫乏\r\n对问题回答的语言虽够，但不能提供充分信息，其内容含糊，过于抽象或过于具体、重复或刻板。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('429', '0', '11', '10', '言语中断\r\n在一种思维或一个概念结束之前，语流中断。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('430', '0', '11', '11', '应答迟缓\r\n病人要比平常花费更多时间来回答问题。他看上去“冷淡”。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('431', '0', '11', '12', '言语障碍总评\r\n由于思维贫乏的核心症状是语量贫乏和言语内容贫乏，总评重点主要在此二项。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('432', '0', '11', '13', '衣着及个人卫生差\r\n病人比平常不注意衣着及个人卫生。衣服邋遢，肮脏或污秽。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('433', '0', '11', '14', '工作或学习不能持久\r\n病人难以找到或维持一个与其年龄、性别相适应的职业(或学业)。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('434', '0', '11', '15', '躯体少动\r\n病人懒于动弹，可能坐在椅子上一连几小时而没有任何自发活动。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('435', '0', '11', '16', '意志缺乏总评\r\n全面评定意志缺乏的严重度，并要考虑病人的年龄和社会地位或出身。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('436', '0', '11', '17', '娱乐的兴趣和活动减少\r\n病人极少或没有任何兴趣或爱好。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('437', '0', '11', '18', '性活动减少\r\n就病人的年龄和婚姻状况而言，其性兴趣和性活动减少。已婚者可能表现为对性生活没有兴趣或只是被动地进行性交。', '无', '可疑', '轻度', '中度 ', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('438', '0', '11', '19', '亲密感缺乏\r\n感到难以与人建立起亲密的感情。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('439', '0', '11', '20', '交友兴趣下降\r\n病人与朋友和同龄人之间交往范围狭小。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('440', '0', '11', '21', '兴趣/社交缺乏总评\r\n应全面评定兴致缺乏／社交缺乏的严重度。并考虑病人的年龄、性别和家庭状况。\r\n兴趣/社交缺乏总评\r\n应全面评定兴致缺乏／社交缺乏的严重度。并考虑病人的年龄、性别和家庭状况。\r\n兴趣/社交缺乏总评\r\n应全面评定兴致缺乏／社交缺乏的严重度。并考虑病人的年龄、性别和家庭状况。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('441', '0', '11', '22', '不注意社交\r\n病人表现为不注意社会工作或活动。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('442', '0', '11', '23', '心理测试时注意不集中\r\n尽管病人有相当的文化和智力水平，但简单的智能测试成绩却较差。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('443', '0', '11', '24', '注意障碍总评\r\n此项评分应评定病人在临床和测试中总的注意力。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('444', '0', '12', '1', '听幻觉\r\n病人声称听到语声、杂音或其他声音,最常见的听幻觉包括听到对病人讲话或叫他名字的声音。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('445', '0', '12', '2', '评论性幻听\r\n指患者听到一种语声对其当时的行为或思想进行实况评述。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('446', '0', '12', '3', '对话性幻听\r\n指患者听到两人或更多人的声音在对话，通常是讨论有关病人的事情。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('447', '0', '12', '4', '躯体或触幻觉\r\n患者体验到特殊的躯体感觉，包括烧灼感、刺痛感，以及感到身体的形状或大小发生了变化。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('448', '0', '12', '5', '嗅幻觉\r\n病人体验到令其极不愉快的气味。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('449', '0', '12', '6', '视幻觉\r\n病人看见实际上并不存在的人或事物。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('450', '0', '12', '7', '幻觉总评\r\n评分应依据幻觉的持续时间和严重程度，沉缅于幻觉和相信程度，以及对其行为影响进行评定，也要考虑幻觉的荒谬性。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('451', '0', '12', '8', '被害妄想\r\n患者认为他人正以某种方式，在阴谋迫害他。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('452', '0', '12', '9', '嫉妒妄想\r\n病人认为其配偶与某人有不正当的男女关系，将各方面的蛛丝马迹都作为“证据”，病人往往竭尽全力以求证实。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('453', '0', '12', '10', '罪恶或过失妄想\r\n病人自认犯有某些可怕的罪行或做了一些不可饶恕的事情。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('454', '0', '12', '11', '夸大妄想\r\n病人认为他自己有特殊的权力或能力。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('455', '0', '12', '12', '宗教妄想\r\n病人沉缅于带宗教色彩的错误信念中。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('456', '0', '12', '13', '躯体妄想\r\n病人认为其身体有病、不正常或有变化。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('457', '0', '12', '14', '关系妄想\r\n病人认为那些无关紧要的谈话、评述或事件都与他有关，或者对他有特殊意义。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('458', '0', '12', '15', '被控制妄想\r\n病人主观体验到他的感情或行动被某种外界力量所控制。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('459', '0', '12', '16', '读心妄想\r\n病人认为人们能读出他的心理或知道他的思想(被洞悉感)。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('460', '0', '12', '17', '思想被广播\r\n病人相信其思想被电台广播，因而他自己或其他人都能听到。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('461', '0', '12', '18', '思想被插入\r\n病人相信有一种并不属于他自己的思想插进他的脑中。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('462', '0', '12', '19', '思想被夺\r\n病人相信其思想被夺走，他开始思考后不久在主观上体验到，思想突然被某种外界力量抽掉。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('463', '0', '12', '20', '妄想评分\r\n此项评分应根据妄想持续的时间、是否沉缅于妄想，相信的程度，以及妄想对病人行动的影响，来进行评分。也要考虑妄想的荒谬性质。未曾提及的妄想也应在此评分。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('464', '0', '12', '21', '衣着和外表\r\n病人衣着奇特或以其它稀奇古怪的方式来改变其外观。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('465', '0', '12', '22', '社交行为和性行为\r\n病人可能做出一些与社会一般规范不相称的事。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('466', '0', '12', '23', '攻击和激越行为\r\n病人行为方式具有攻击性和激越性，常常难以预料。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('467', '0', '12', '24', '重复或刻板行为\r\n病人搞出一套重复性或仪式性的动作，反复地做个不停。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('468', '0', '12', '25', '怪异行为总评\r\n评定时应考虑怪异行为的类型、偏离社会规范的程度、病人对其行为偏离正常的认识，以及行为明显怪异的程度。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('469', '0', '12', '26', '出轨（联想散漫）\r\n自发性言语从一个主体脱离原先轨道滑到另一个间接有关或完全无关的主题上去，或从一个观点突然转到另一个观点。概念之间的联系常很模糊，有时竟毫无关系。', '无', '可疑', '轻度', '中度 ', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('470', '0', '12', '27', '言语不切题\r\n对问题的回答显得含糊、不切题、甚至无关。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('471', '0', '12', '28', '言语不连贯\r\n言语不连贯是指每个句子里的词或短语之间没有联系(包括思维破裂)。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('472', '0', '12', '29', '逻辑障碍\r\n这种言语的推理结论明显不合逻辑，在上句与下句之间没有逻辑关系。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('473', '0', '12', '30', '赘述\r\n病人表达主题时极其迂回曲折，迟迟才达到目标。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('474', '0', '12', '31', '言语云集\r\n与日常习惯相比，自发性的语量明显较多，病人讲得很快，并难以打断。', '无', '可疑', '轻度', '中度 ', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('475', '0', '12', '32', '言语随境转移\r\n在讨论或交谈的过程中，病人的话讲到一半就停下来，转移到有关周围事物的主题上去。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('476', '0', '12', '33', '音联\r\n是一种根据词音而不是词意来选用词汇的言语方式。因此言语显得含糊、难以理解，或引进不少多余的词汇。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('477', '0', '12', '34', '阳性思维形式障碍总评\r\n评定时应考虑异常类型，对病人交流能力的影响，异常频度与严重程度。', '无', '可疑', '轻度', '中度', '重度', '极重', null);
INSERT INTO `shi_ti` VALUES ('480', '0', '13', '1', '强迫思维占据时间：你有多少时间被强迫思维所占据？是否经常出现？（不包括非强迫性的、与自我相协调的、过分而合理的反复思考，或沉缅于这种想法。）', '无。', '轻度。偶尔出现（一天内少于1小时。）', '中度。经常出现（一天内1-3小时。）', '重度。频繁出现（一天内3-8小时。）', '极重度。近乎持续出现（一天内超过8小时。）', null, null);
INSERT INTO `shi_ti` VALUES ('481', '0', '13', '2', '社交或工作能力受强迫思维影响的程度：强迫思维使你在社交或工作中受到多少干扰？有没有因此而使你不能完成某件事情？（如果患者现在没有工作，那么假设患者在工作，以评定其受干扰强度。）', '无', '轻度。轻度影响社交或工作，但整体活动未受影响。', '中度。肯定影响社交或工作，但还可加以控制。', '重度。社交或工作受到相应程度的损害。', '极重度。丧失社交或工作能力。', null, null);
INSERT INTO `shi_ti` VALUES ('482', '0', '13', '3', '强迫思维所致痛苦烦恼程度：你感受到多少痛苦烦恼？（对于大多数病人而言，这种痛苦也就等于焦虑，但也有例外。如，病人会诉说感“烦恼不安”，但否认有“焦虑”。在此只评定由强迫思维所致焦虑，而非广泛性焦虑或与其它症状有关的焦虑。）', '无', '轻度。较少有痛苦烦恼，且程度较轻。', '中度。经常有痛苦烦恼，但还能控制。', '重度。感明显痛苦烦恼，且次数很多。', '极重度。近乎持续感烦恼，以至什么事情都不能做。', null, null);
INSERT INTO `shi_ti` VALUES ('483', '0', '13', '4', '对强迫思维的抵制：你做过多少努力来摆脱强迫思维？一旦强迫思维出现，你多少次试图转移注意力或不理会它？（在此对试图摆脱强迫思维所做的努力作评定，而不论事实上成功与否。）', '一直努力去克服强迫思维，或者症状轻微而无需主动去抵制。', '大部分时间里试图去克服。', '做过一些努力试图去克服。', '服从于所有强迫思维而没有克服的企图，但有些勉强。', '完全并且乐意服从于所有的强迫思维。', null, null);
INSERT INTO `shi_ti` VALUES ('484', '0', '13', '5', '控制强迫思维的程度：你能控制住多少强迫思维？你成功地阻止或转移了多少强迫思维？', '完全能控制。', '基本能控制。能通过做些努力和集中思想来阻止或转移强迫思维。', '能控制一些。有时能阻止或转移强迫思维。', '很少能控制。很少能成功地阻止强迫思维的进行。很难因转移注意力而摆脱强迫思维。', '完全不能控制。完全无意地在体验强迫思维，很少能甚至仅是瞬间地摆脱强迫思维。', null, null);
INSERT INTO `shi_ti` VALUES ('485', '0', '13', '6', '你在强迫行为上用了多少时间：你有多少时间用于强迫行为上？是否经常出现？（如果强迫行为主要表现为有关日常生活的仪式动作，则作以下提问：）你在日常活动中出现仪式动作时，完成这项活动所用时间比正常人增加多少？（大多数病人的强迫动作是强迫性行为表现，如反复洗手，但也有些病人的强迫行为不容易被人察觉，如默默地反复核对。）', '无。', '轻度。（每天少于1小时），或偶尔出现。', '中度（每天1-3小时），或频繁出现（一天多于8次，但多数时间里没有。）', '重度（每天3-8小时），或出现非常频繁（一天多于8次，且多数时间里都有。）', '极重度。（每天多于8小时）。或几乎持续性出现（出现次数太多而无法统计，并且几乎每个小时都出现数次。）', null, null);
INSERT INTO `shi_ti` VALUES ('486', '0', '13', '7', '受强迫行为干扰的程度：强迫行为使你在社交或在工作中受到多少干扰？有没有因此使你不能做某些事情？（如果目前没有工作，则假定病人在工作来评定其受干扰程度。）', '无。', '轻度。轻度干扰社交或工作。但整体活动未受影响。', '中度。明显干扰社交或工作，但还能控制。', '重度。导致社交或工作相当程度受损。', '极重度。丧失社交或工作能力。', null, null);
INSERT INTO `shi_ti` VALUES ('487', '0', '13', '8', '强迫行为所致痛苦烦恼程度：如果阻止你正在进行中的强迫行为，你会有什么感觉？（过一会儿再问以下问题）你会变得怎样焦虑？（在此指突然终止病人的强迫行为而不予保证会允许再做时，评定病人所体验到的痛苦烦恼程度。对大多数病人而言，执行强迫行为时会减少焦虑，所以在作以上评定时，若检查者确定病人的焦虑确实在阻止执行强迫行为后反而减少了，那么再问：）在进行强迫行为、直至完成并感到满意为止的这个时期内，你感受到多少不安？）', '无。', '轻度。阻止强迫行为后仅有轻度焦虑，或在进行强迫行为时只有轻度焦虑。', '中度。在强迫行为受阻时，焦虑有所增加，但仍可忍受，或在执行强迫行为时，焦虑有所增加而仍可忍受。', '重度。在执行强迫行为时，或被阻止执行时，出现显著持久的焦虑，且越来越感不安。', '极重度。对指在改变强迫行为的任何干预，或在执行强迫行为时焦虑体验难以忍受。', null, null);
INSERT INTO `shi_ti` VALUES ('488', '0', '13', '9', '对强迫行为产生的抵制程度：你做了多少努力以摆脱强迫行为？（只评所作的努力，而不论事实上成功与否。）', '总在努力试图摆脱强迫行为，或症状轻微而无需摆脱。', '大多数时间在试图摆脱。', '做过一些努力欲摆脱。 ', '执行所有的强迫行为，没有想控制它们的企图，但做时有些勉强。', '完全并心甘情愿地执行所有的强迫行为。', null, null);
INSERT INTO `shi_ti` VALUES ('489', '0', '13', '10', '控制强迫行为的程度：你想执行强迫行为的内心驱动力有多强？（过一会儿再问以下问题）你能控制住多少强迫行为？', '完全控制。', '基本能控制。感到有压力要去执行强迫行为，但往往能自主地控制住。', '部分能控制。感到强烈的压力必须去执行强迫行为，不努力的话便控制不住。', '很少能控制。有很强烈的欲望去执行强迫行为，费尽心力也只能延迟片刻。', '不能控制。完全不由自主地欲望去执行强迫行为，即使作片刻的延迟也几乎不能。', null, null);
INSERT INTO `shi_ti` VALUES ('490', '0', '14', '1', '做什么事都没兴趣，沒意思', '有', '有几天', '一半以上时间', '几乎天天', null, null, null);
INSERT INTO `shi_ti` VALUES ('491', '0', '14', '2', '感到心情低落，抑郁，沒希望', '有', '有几天', '一半以上时间', '几乎天天', null, null, null);
INSERT INTO `shi_ti` VALUES ('492', '0', '14', '3', '入睡困难，总是醒着，或睡得太多嗜睡', '有', '有几天', '一半以上时间', '几乎天天', null, null, null);
INSERT INTO `shi_ti` VALUES ('493', '0', '14', '4', '常感到很疲倦，沒劲 ', '有', '有几天', '一半以上时间', '几乎天天', null, null, null);
INSERT INTO `shi_ti` VALUES ('494', '0', '14', '5', '口味不好，或吃的太多  ', '有', '有几天', '一半以上时间', '几乎天天', null, null, null);
INSERT INTO `shi_ti` VALUES ('495', '0', '14', '6', '自己对自己不满，觉得自己是个失败者，或让家人丟脸了', '有', '有几天', '一半以上时间', '几乎天天', null, null, null);
INSERT INTO `shi_ti` VALUES ('496', '0', '14', '7', '无法集中精力，即便是读报纸或看电视时，记忆力下降', '有', '有几天', '一半以上时间', '几乎天天', null, null, null);
INSERT INTO `shi_ti` VALUES ('497', '0', '14', '8', '行动或说话缓慢到引起人们的注意，或刚好相反，坐臥不安；烦躁易怒易怒，到处走动', '有', '有几天', '一半以上时间', '几乎天天', null, null, null);
INSERT INTO `shi_ti` VALUES ('498', '0', '14', '9', '有不如一死了之的念头，或想怎样伤害自己一下', '有', '有几天', '一半以上时间', '几乎天天', null, null, null);
INSERT INTO `shi_ti` VALUES ('499', '0', '15', '1', '紧张、焦虑或愤怒', '根本没有', '有些天存在哪些感觉', '超过一半的时间都是如此', '基本每天都是如此', null, null, null);
INSERT INTO `shi_ti` VALUES ('500', '0', '15', '2', '易被激怒', '根本没有', '有些天存在哪些感觉', '超过一半的时间都是如此', '基本每天都是如此', null, null, null);
INSERT INTO `shi_ti` VALUES ('501', '0', '15', '3', '害怕什么可怕的事情发生', '根本没有', '有些天存在哪些感觉', '超过一半的时间都是如此', '基本每天都是如此', null, null, null);
INSERT INTO `shi_ti` VALUES ('502', '0', '15', '4', '担心很多事情', '根本没有', '有些天存在哪些感觉', '超过一半的时间都是如此', '基本每天都是如此', null, null, null);
INSERT INTO `shi_ti` VALUES ('503', '0', '15', '5', '疲劳，坐不住', '根本没有', '有些天存在哪些感觉', '超过一半的时间都是如此', '基本每天都是如此', null, null, null);
INSERT INTO `shi_ti` VALUES ('504', '0', '15', '6', '不能停止或不能控制的担心', '根本没有', '有些天存在哪些感觉', '超过一半的时间都是如此', '基本每天都是如此', null, null, null);
INSERT INTO `shi_ti` VALUES ('505', '0', '15', '7', '很难放松', '根本没有', '有些天存在哪些感觉', '超过一半的时间都是如此', '基本每天都是如此', null, null, null);

-- ----------------------------
-- Table structure for `xing_li_ce_ping_xiang_mu`
-- ----------------------------
DROP TABLE IF EXISTS `xing_li_ce_ping_xiang_mu`;
CREATE TABLE `xing_li_ce_ping_xiang_mu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `isJianCe` tinyint(1) NOT NULL DEFAULT '0',
  `liangBiaoId` int(11) DEFAULT NULL,
  `jianCeXiangMu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xing_li_ce_ping_xiang_mu
-- ----------------------------

-- ----------------------------
-- Table structure for `yao_wu`
-- ----------------------------
DROP TABLE IF EXISTS `yao_wu`;
CREATE TABLE `yao_wu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `yaoMing` varchar(255) NOT NULL,
  `guiGe` varchar(255) NOT NULL,
  `yongLiang` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yao_wu
-- ----------------------------
INSERT INTO `yao_wu` VALUES ('1', '0', '西酞普兰', '20mg', '20mg');
INSERT INTO `yao_wu` VALUES ('2', '0', '艾司西酞普兰', '10mg', '5 mg');
INSERT INTO `yao_wu` VALUES ('3', '0', '艾司西酞普兰', '10mg', '10 m');
INSERT INTO `yao_wu` VALUES ('4', '0', '盐酸氟西汀', '20mg', '20mg');
INSERT INTO `yao_wu` VALUES ('5', '0', '盐酸氟西汀', '20mg', '40mg');
INSERT INTO `yao_wu` VALUES ('6', '0', '盐酸帕罗西汀', '20mg', '20mg');
INSERT INTO `yao_wu` VALUES ('7', '0', '盐酸帕罗西汀', '20mg', '40mg');
INSERT INTO `yao_wu` VALUES ('8', '0', '舍曲林', '50mg', '50mg');
INSERT INTO `yao_wu` VALUES ('9', '0', '盐酸度洛西汀肠溶片', '20mg', '20mg');
INSERT INTO `yao_wu` VALUES ('10', '0', '盐酸度洛西汀肠溶片', '20mg', '40mg');
INSERT INTO `yao_wu` VALUES ('11', '0', '盐酸度洛西汀肠溶片', '20mg', '60mg');
INSERT INTO `yao_wu` VALUES ('12', '0', '文拉法辛', '75mg', '75mg');
INSERT INTO `yao_wu` VALUES ('13', '0', '文拉法辛', '75mg', '225mg');
INSERT INTO `yao_wu` VALUES ('14', '0', '氟哌噻吨美利曲辛', '1片', '1片');
INSERT INTO `yao_wu` VALUES ('15', '0', '地西泮', '2.5mg', '2.5-5.0mg');
INSERT INTO `yao_wu` VALUES ('16', '0', '氯硝西泮', '2mg', '0.5mg');
INSERT INTO `yao_wu` VALUES ('17', '0', '氯硝西泮', '2mg', '1mg');
INSERT INTO `yao_wu` VALUES ('18', '0', '氯硝西泮', '2mg', '2mg');
INSERT INTO `yao_wu` VALUES ('19', '0', '艾司唑仑', '1mg', '1mg');
INSERT INTO `yao_wu` VALUES ('20', '0', '艾司唑仑', '1mg', '2mg');
INSERT INTO `yao_wu` VALUES ('21', '0', '酒石酸唑吡坦', '10mg', '10mg');
INSERT INTO `yao_wu` VALUES ('22', '0', '右佐匹克隆', '3mg', '1.5mg');
INSERT INTO `yao_wu` VALUES ('23', '0', '右佐匹克隆', '3mg', '3mg');
INSERT INTO `yao_wu` VALUES ('24', '0', '补肾益脑丸', '0.2g/粒', '10粒 ');
INSERT INTO `yao_wu` VALUES ('25', '0', '百乐眠胶囊', '0.27g/片', '4片');
INSERT INTO `yao_wu` VALUES ('26', '0', '心脑舒口服液', '10ml', '1支');
INSERT INTO `yao_wu` VALUES ('27', '0', '心脑舒口服液', '10ml', '2支 ');
INSERT INTO `yao_wu` VALUES ('28', '0', '舒肝解郁胶囊', '0.36g', '2片');
INSERT INTO `yao_wu` VALUES ('29', '0', '舒肝颗粒', '3g', '3g');
INSERT INTO `yao_wu` VALUES ('30', '0', '舒肝颗粒', '3g', '6g');
INSERT INTO `yao_wu` VALUES ('31', '0', '乌灵胶囊', '0.33g', '3片');
INSERT INTO `yao_wu` VALUES ('32', '0', '安神补脑颗粒', '1g', '1g/');
INSERT INTO `yao_wu` VALUES ('33', '0', '新乐康片', '0.25g', '3粒');
INSERT INTO `yao_wu` VALUES ('34', '0', '利培酮', '1mg', '1mg');
INSERT INTO `yao_wu` VALUES ('35', '0', '利培酮', '1mg', '2mg');
INSERT INTO `yao_wu` VALUES ('36', '0', '利培酮', '1mg', '4mg');
INSERT INTO `yao_wu` VALUES ('37', '0', '富马酸喹硫平', '50mg', '50mg');
INSERT INTO `yao_wu` VALUES ('38', '0', '富马酸喹硫平', '50mg', '100mg');
INSERT INTO `yao_wu` VALUES ('39', '0', '富马酸喹硫平', '50mg', '200mg');
INSERT INTO `yao_wu` VALUES ('40', '0', '奥氮平', '10mg', '10mg');
INSERT INTO `yao_wu` VALUES ('41', '0', '奥氮平', '10mg', '20mg');
INSERT INTO `yao_wu` VALUES ('42', '0', '氟哌啶醇', '2mg', '2mg');
INSERT INTO `yao_wu` VALUES ('43', '0', '氟哌啶醇', '2mg', '4mg');
INSERT INTO `yao_wu` VALUES ('44', '0', '丙戊酸钠缓释片', '0.5g', '10-15mg/kg/日');
INSERT INTO `yao_wu` VALUES ('45', '0', '丙戊酸钠缓释片', '0.5g', '20-30mg/kg/日');
INSERT INTO `yao_wu` VALUES ('46', '0', '丙戊酸镁', '200mg', '200mg');
INSERT INTO `yao_wu` VALUES ('47', '0', '丙戊酸镁', '200mg', '300mg');
INSERT INTO `yao_wu` VALUES ('48', '0', '丙戊酸镁', '200mg', '400mg');
INSERT INTO `yao_wu` VALUES ('49', '0', '碳酸锂', '500mg ', '500mg ');
INSERT INTO `yao_wu` VALUES ('50', '0', '碳酸锂', '250mg', '1000mg');

-- ----------------------------
-- Table structure for `yao_wu_zhi_liao`
-- ----------------------------
DROP TABLE IF EXISTS `yao_wu_zhi_liao`;
CREATE TABLE `yao_wu_zhi_liao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `yaoMing` varchar(255) NOT NULL,
  `guiGe` varchar(255) NOT NULL,
  `yongLiang` varchar(255) NOT NULL,
  `yongFa` varchar(255) DEFAULT NULL,
  `zhenLiaoFangAnId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yao_wu_zhi_liao
-- ----------------------------

-- ----------------------------
-- Table structure for `yi_sheng`
-- ----------------------------
DROP TABLE IF EXISTS `yi_sheng`;
CREATE TABLE `yi_sheng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `keShi` varchar(255) NOT NULL,
  `yiYuan` varchar(255) NOT NULL,
  `xingMing` varchar(255) NOT NULL,
  `xingBie` int(11) NOT NULL,
  `jueSe` varchar(255) NOT NULL,
  `isZhuRen` tinyint(1) NOT NULL DEFAULT '0',
  `lianXiFangShi` varchar(255) NOT NULL,
  `keShiId` int(11) NOT NULL,
  `dengLuId` int(11) DEFAULT NULL,
  `yiYuanId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yi_sheng
-- ----------------------------

-- ----------------------------
-- Table structure for `yi_yuan`
-- ----------------------------
DROP TABLE IF EXISTS `yi_yuan`;
CREATE TABLE `yi_yuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `mingCheng` varchar(255) NOT NULL,
  `daiHao` varchar(255) NOT NULL,
  `sheng` varchar(255) NOT NULL,
  `shi` varchar(255) NOT NULL,
  `xian` varchar(255) NOT NULL,
  `lianXiDianHua` varchar(255) NOT NULL,
  `dengLuId` int(11) NOT NULL,
  `todayCount` int(11) DEFAULT NULL,
  `isUse` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yi_yuan
-- ----------------------------
INSERT INTO `yi_yuan` VALUES ('1', '0', '唐山工人医院', '1301010000', '河北省', '唐山市', '市辖区', '18632505440', '2', '0', '1');

-- ----------------------------
-- Table structure for `zhen_liao_fang_an`
-- ----------------------------
DROP TABLE IF EXISTS `zhen_liao_fang_an`;
CREATE TABLE `zhen_liao_fang_an` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `ciShu` int(11) DEFAULT '1',
  `jiChuXinXiId` int(11) NOT NULL,
  `riQi` datetime DEFAULT NULL,
  `fuZhenShiJian` int(11) DEFAULT NULL,
  `jianCeXiangMu` varchar(255) DEFAULT NULL,
  `xinLiCePingXiangMu` varchar(255) DEFAULT NULL,
  `xinShenTiaoJie` varchar(255) DEFAULT NULL,
  `xinShenZhenDuan` varchar(255) DEFAULT NULL,
  `huiFangZhuangTai` tinyint(1) DEFAULT '0',
  `huiFangNeiRong` text,
  `yongHuId` varchar(255) DEFAULT NULL,
  `xingMing` varchar(255) DEFAULT NULL,
  `xingBie` int(11) DEFAULT NULL,
  `chuShengNian` int(11) DEFAULT NULL,
  `chuShengYue` int(11) DEFAULT NULL,
  `chuShengRi` int(11) DEFAULT NULL,
  `jingShenKeYiSheng` varchar(255) DEFAULT NULL,
  `cePingShi` varchar(255) DEFAULT NULL,
  `shouZhenRiQi` datetime DEFAULT NULL,
  `yiYuanId` int(11) DEFAULT NULL,
  `isGuiDang` tinyint(1) DEFAULT '0',
  `gdRiQi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zhen_liao_fang_an
-- ----------------------------
