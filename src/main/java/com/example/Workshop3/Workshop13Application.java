package main.java.com.example.Workshop3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@SpringBootApplication
public class Workshop13Application implements ApplicationRunner {



	private static final Logger logger = LoggerFactory.getLogger(Workshop13Application.class);

	public static String userPath;

	public static void main(String[] args)  {
//		String userDir = "";
//		SpringApplication app = new SpringApplication(Workshop13Application.class);
//		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
//		if(appArgs.containsOption("dataDir")){
//			userDir = appArgs.getOptionValues("dataDir").get(0);
//			Path paths = Paths.get(userDir);
//			if(!Files.exists(paths)){
//				Files.createDirectories(paths);
//			}
//		} else{
//			logger.info(userDir);
//			System.out.println("No path provided");
//
//		}
		SpringApplication.run(Workshop13Application.class, args);

//		app.run(args);



	}

	@Override
	public void run( ApplicationArguments args ) throws IOException
	{

		if(args.containsOption("dataDir")){
			String userDir = System.getProperty("user.dir") + args.getOptionValues("dataDir").get(0);
			Path paths = Paths.get(userDir);

			userPath = paths.toAbsolutePath().toString();
			System.out.println(userPath);
			if(!Files.exists(paths)){
				Files.createDirectories(paths);
			} else {
				System.out.println("Directory exists.");
			}



		} else{
			System.out.println("No path provided");
			System.exit(0);
	}

}
}
