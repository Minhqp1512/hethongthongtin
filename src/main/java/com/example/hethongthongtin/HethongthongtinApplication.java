package com.example.hethongthongtin;

import com.example.hethongthongtin.model.User;
import com.example.hethongthongtin.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.random.*;

@SpringBootApplication
public class HethongthongtinApplication {

	public static void main(String[] args) {
		SpringApplication.run(HethongthongtinApplication.class, args);
	}

}
@Component
class DataGenerator implements CommandLineRunner{
	private final UserRepository userRepository;

	public DataGenerator(UserRepository userRepository){
		this.userRepository=userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Set<String> generatedUsernames = new HashSet<>();
		Random random= new Random();
		for(int i=0; i<5000000; i++){
			User user= new User();
			user.setUsername(generateRandomUsername(generatedUsernames));
			user.setFull_name(generateRandomFullname());
			user.setAge(random.nextInt(99)+1);
			user.setAvartar(generateRandomAvartar());
		}
	}

	private String generateRandomAvartar() {
		String[] avatar={
				"https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyz-77X11MoGE22xVjjPhbpW6lPj6I0SkcTQ&usqp=CAU",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvPx5Ngn3BqU_b1o4MO5-90QnJXVEdVLYmaA&usqp=CAU",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdV3ip1gxZ9bM13uZjWbiCpiETs2AVz3GS_Q&usqp=CAU",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDtd0soCSRdpo8Y5klekJdABh4emG2P29jwg&usqp=CAU",
				"https://cdn3.vectorstock.com/i/1000x1000/30/97/flat-business-man-user-profile-avatar-icon-vector-4333097.jpg",
				"https://img.freepik.com/premium-vector/female-user-profile-avatar-is-woman-character-screen-saver-with-emotions_505620-617.jpg",
				"https://static.vecteezy.com/system/resources/previews/002/002/403/original/man-with-beard-avatar-character-isolated-icon-free-vector.jpg",
				"https://banner2.cleanpng.com/20180625/req/kisspng-computer-icons-avatar-business-computer-software-user-avatar-5b3097fcae25c3.3909949015299112927133.jpg",
				"https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes.png",
				"https://as1.ftcdn.net/v2/jpg/02/59/39/46/1000_F_259394679_GGA8JJAEkukYJL9XXFH2JoC3nMguBPNH.jpg",
				"https://www.shutterstock.com/image-vector/default-avatar-profile-icon-vector-260nw-1725655669.jpg",
				"https://cdn.pixabay.com/photo/2020/07/14/13/07/icon-5404125_1280.png",
				"https://www.shareicon.net/data/512x512/2016/08/05/806962_user_512x512.png",
				"https://cdn3.iconfinder.com/data/icons/essential-rounded/64/Rounded-31-512.png",
		};
		return avatar[new Random().nextInt(avatar.length)];

	}
	private String generateRandomFullname() {
		String[] names={"Đức Thắng","Văn Phú","Hà Đông","Lào Cai","Hà Tĩnh","Nam Định","Ninh Bình","Bắc Giang","Bắc Ninh","Bắc Nam","An giang","An Tường","Phú Nhuận","Thuận Thành","Tiền Giang","Hà Tĩnh","Kiên Giang","Bình Thuận","Ninh Bình","Hải Hưng","Thanh Vân","Văn Đạt","Cát Tường","Minh Anh","Khắc Việt","Ngọc Giang","Ngọc Hưng", "Hồng Nhung","Thu Hiền","Thu Uyên","Hải yến","Ngọc Quân","Dăng Khoa","Minh Đức","Hồng Đức"};
		return names[(int)(Math.random()* names.length)];
	}

	private String generateRandomUsername(Set<String> existUsername) {
		String username;
		do{
			username= RandomStringUtils.randomAlphanumeric(10);
		}
		while(!existUsername.add(username));
		return username;
	}
}
