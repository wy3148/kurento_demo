/*
 * (C) Copyright 2014 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
package controllers;

import static java.util.concurrent.TimeUnit.SECONDS;
import play.libs.Akka;
import play.libs.F.*;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import scala.concurrent.duration.Duration;
import views.html.index;
import akka.actor.ActorRef;
import akka.actor.Cancellable;
import akka.actor.Props;
import play.mvc.Http.RequestBody;
import java.io.IOException;

import org.kurento.client.factory.KurentoClient;

public class HelloWorldApp extends Controller {

	public static Result startDemo() throws IOException {
		
		HelloWorldAppInst demo_app = new HelloWorldAppInst();
		
		RequestBody body = request().body();
	    String textBody = body.asText();
		String sdpAnswer = demo_app.processRequest(textBody);
		return ok(sdpAnswer);
	}
}
