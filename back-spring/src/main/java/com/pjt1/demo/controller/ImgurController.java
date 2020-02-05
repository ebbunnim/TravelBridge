// package com.pjt1.demo.controller;

// import com.pjt1.demo.model.dto.Files;
// import com.pjt1.demo.model.service.FilesService;
// import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// import io.swagger.annotations.ApiOperation;

// import java.awt.image.BufferedImage;
// import java.io.BufferedReader;
// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import java.net.URLEncoder;
// import java.util.HashMap;
// import java.util.Map;

// import javax.imageio.ImageIO;
// import javax.servlet.http.HttpServletRequest;


// @RestController
// public class ImgurController {
    
//     @Autowired
//     private FilesService service;
    
//     @ExceptionHandler
//     public ResponseEntity<Map<String, Object>> handle(Exception e) {
//         return handleFail(e.getMessage(), HttpStatus.OK); // 전송에는 지장 없음
//     }

//     public ResponseEntity<Map<String, Object>> handleSuccess(Object data) {
//         Map<String, Object> resultMap = new HashMap<String, Object>();
//         resultMap.put("state", "ok");
//         resultMap.put("data", data);
//         return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
//     }

//     public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus state) {
//         Map<String, Object> resultMap = new HashMap<String, Object>();
//         resultMap.put("state", "fail");
//         resultMap.put("data", data);
//         return new ResponseEntity<Map<String, Object>>(resultMap, state);
//     }



//     @ApiOperation("Imgur 형식 이미지 파일 받아오기")
//     @PostMapping("/Files/Post") // 크롤링한 결과는 /Files/
//     public ResponseEntity<Map<String, Object>> getImgurContent (HttpServletRequest request) {
        

//         // vue에서 받아온 link - image file
//         System.out.println(request);
        
//         // map으로 받아야
//         String files_url = request.getParameter("files_url"); // 이미지 소스
//         String path_no = request.getParameter("path_no"); //이미지 등록된 게시물 번호
        

//         // 이 형식에 맞게 insert files

//         Files files =  new Files();
//         files.setFiles_url(files_url);
//         files.setPath_type(0); // Post이므로 다 0처리
//         files.setPath_no(Integer.parseInt(path_no));
//         service.insert(files);
                
//         return handleSuccess(files);
//     }
    
//     // @ApiOperation("Imgur 형식 이미지 파일 받아오기")
//     // @RequestMapping("/Image/Upload")
//     // public ResponseEntity<Map<String, Object>> (HttpServletResponse res) {

//     // }
//     // public static String getImgurContent(String clientID) throws Exception {

//     // clientID = "5945b2cec60a877";

//     // URL url;

//     // url = new URL("https://api.imgur.com/3/image");
//     // HttpURLConnection conn = (HttpURLConnection) url.openConnection();

//     // // encoding 자리에 imgur에서 처리한 파일 형식으로 넣어야 함 
//     // String data = URLEncoder.encode("image", "UTF-8") + "="
//     //         + URLEncoder.encode("https://i.imgur.com/lnX1JMq.png", "UTF-8");
//     // conn.setDoOutput(true);
//     // conn.setDoInput(true);
//     // conn.setRequestMethod("POST");
//     // conn.setRequestProperty("Authorization", "Client-ID " + clientID);
//     // conn.setRequestMethod("POST");
//     // conn.setRequestProperty("Content-Type",
//     //         "application/x-www-form-urlencoded");

//     // conn.connect();
//     // StringBuilder stb = new StringBuilder();
//     // OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//     // wr.write(data);
//     // wr.flush();

//     // // Get the response
//     // BufferedReader rd = new BufferedReader(
//     //         new InputStreamReader(conn.getInputStream()));
//     // String line;
//     // while ((line = rd.readLine()) != null) {
//     //     stb.append(line).append("\n");
//     // }
//     // wr.close();
//     // rd.close();

//     // System.out.println(stb.toString());
//     // // 여기서 string으로 return하지 말고 DB에 file 넣는 형식으로 하면 될듯?
//     // return stb.toString();
//     // }

// }