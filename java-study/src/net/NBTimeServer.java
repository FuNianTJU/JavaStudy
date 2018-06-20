
package net;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

/**
 * 非阻塞的时间服务器
 * @author yan
 */
public class NBTimeServer {
	//在默认端口创建一个TimeServer
	public NBTimeServer() throws Exception{
		acceptConnections ();
	}
	
	//核心代码块
	private static void acceptConnections() throws Exception{
		Selector selector = Selector.open();
		
		//在端口8080和8081绑定两个非阻塞的ServerSocketChannel
		ServerSocketChannel ssChannel1 = ServerSocketChannel.open();
		ssChannel1.configureBlocking(false);
		ssChannel1.socket().bind(new InetSocketAddress(8090));
		
		ServerSocketChannel ssChannel2 = ServerSocketChannel.open();
		ssChannel2.configureBlocking(false);
		ssChannel2.socket().bind(new InetSocketAddress(8080));
		
		//注册两个ServerSocketChannel
		ssChannel1.register(selector, SelectionKey.OP_ACCEPT);
		ssChannel2.register(selector, SelectionKey.OP_ACCEPT);
		
		while(true){
			selector.select();
			Iterator it = selector.selectedKeys().iterator();
			
			while(it.hasNext()){
				SelectionKey selKey = (SelectionKey)it.next();
				//删除得到的key,表示key对应的channel会被处理
				it.remove();
				if(selKey.isAcceptable()){
					//得到key对应的ServerSocketChannel
					ServerSocketChannel ssChannel = (ServerSocketChannel)selKey.channel();
					//得到客户端请求连接的SocketChannel
					SocketChannel socketChannel = ssChannel.accept();
					
					if(socketChannel!=null){
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						buffer.put(new Date().toString().getBytes());
						buffer.flip();
						//把当前时间写入
						socketChannel.write(buffer);
						socketChannel.close();
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		try{
			NBTimeServer nbt = new NBTimeServer();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
















