// File generated by rpc compiler. Do not edit.

package org.commoncrawl.rpc;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.util.StringUtils;
import org.commoncrawl.rpc.*;
import org.commoncrawl.async.EventLoop;

public interface RPCTestService extends ActorInterface {

	public static final Log LOG_PRIVATE = LogFactory.getLog(RPCTestService.class);

	/** interface specification **/

	// method hello (in org.commoncrawl.rpc.UnitTestStruct1, out UnitTestStruct1);
	void hello(IncomingMessageContext<org.commoncrawl.rpc.UnitTestStruct1, org.commoncrawl.rpc.UnitTestStruct1> message)
			throws RPCException;

	/** server specification struct **/
	public static RPCSpecification spec = new RPCSpecification("RPCTestService", new RPCTestService.Dispatcher());

	// Async Client  Stub
	public static class AsyncStub extends ActorInterface.AsyncStub {

		// constructor
		public AsyncStub(Channel channel, EventLoop optionalEventLoop) {
			super(channel, optionalEventLoop);
		}

		// public OutgoingMessageContext<UnitTestStruct1,UnitTestStruct1> hello(UnitTestStruct1 input,OutgoingMessageContext<UnitTestStruct1,UnitTestStruct1> callback) throws RPCException
		public OutgoingMessageContext<org.commoncrawl.rpc.UnitTestStruct1, org.commoncrawl.rpc.UnitTestStruct1> hello(
				org.commoncrawl.rpc.UnitTestStruct1 input,
				OutgoingMessageContext.Callback<org.commoncrawl.rpc.UnitTestStruct1, org.commoncrawl.rpc.UnitTestStruct1> callback)
				throws RPCException {
			OutgoingMessageContext<org.commoncrawl.rpc.UnitTestStruct1, org.commoncrawl.rpc.UnitTestStruct1> request = new OutgoingMessageContext<org.commoncrawl.rpc.UnitTestStruct1, org.commoncrawl.rpc.UnitTestStruct1>(
					spec._name, "hello", input, new org.commoncrawl.rpc.UnitTestStruct1(), callback);
			getChannel().sendRequest(request);
			return request;
		}

	}

	// Blocking Client Stub
	public static class BlockingStub extends ActorInterface.BlockingStub<RPCTestService.AsyncStub> {
		// constructor

		public BlockingStub(Channel channel, EventLoop optionalEventLoop) {
			super(new AsyncStub(channel, optionalEventLoop));
		}

		// public UnitTestStruct1 hello(UnitTestStruct1 input) throws RPCException
		@SuppressWarnings("unchecked")
		public org.commoncrawl.rpc.UnitTestStruct1 hello(org.commoncrawl.rpc.UnitTestStruct1 input) throws RPCException {

			final CountDownLatch latch = new CountDownLatch(1);

			OutgoingMessageContext<org.commoncrawl.rpc.UnitTestStruct1, org.commoncrawl.rpc.UnitTestStruct1> request = this
					.getAsyncStub().hello(input, new OutgoingMessageContext.Callback() {

						public void requestComplete(OutgoingMessageContext request) {
							latch.countDown();
						}
					});

			try {
				if (super.waitForResult(latch)) {
					return request.getOutput();
				}
				throw new RPCException("RPC Timeout");
			} catch (IOException e) {
				LOG_PRIVATE.error(StringUtils.stringifyException(e));
				throw new RPCException(e);
			}
		}

	}

	/** typed dispatcher object **/
	public static class Dispatcher implements RPCMessageDispatcher {
		//@Override
		public void dispatch(ActorInterface instance, RPCServerChannel serverChannel, String serviceId,
				String methodName, DataInputStream messagePayload, int requestId, Channel channel) throws RPCException {

			if (methodName.equals("hello")) {
				org.commoncrawl.rpc.UnitTestStruct1 input = new org.commoncrawl.rpc.UnitTestStruct1();
				org.commoncrawl.rpc.UnitTestStruct1 output = new org.commoncrawl.rpc.UnitTestStruct1();
				try {
					input.deserialize(messagePayload, new BinaryProtocol());
				} catch (IOException e) {
					LOG_PRIVATE.error(StringUtils.stringifyException(e));
					throw new RPCException(e);
				}

				IncomingMessageContext<org.commoncrawl.rpc.UnitTestStruct1, org.commoncrawl.rpc.UnitTestStruct1> messageData = new IncomingMessageContext<org.commoncrawl.rpc.UnitTestStruct1, org.commoncrawl.rpc.UnitTestStruct1>(
						channel, requestId, input, output);
				// Invoke hello
				((RPCTestService) instance).hello(messageData);

			}

			else {
				LOG_PRIVATE.error("UNKNOWN METHOD NAME:" + methodName);

			}
		}
	}

	/** typed actor object **/
	public static class InProcessActorFactory {
		public static InProcessActor createInProcessActor(final RPCTestService instance, ThreadPoolExecutor executor,
				InProcessActor.Events optionalListener) throws IOException {
			InProcessActor actor = new InProcessActor(executor, optionalListener) {

				@SuppressWarnings("unchecked")
				@Override
				public void dispatch(Channel channel, IncomingMessage message) throws RPCException {
					if (message.getServiceName().equals(spec._name)) {
						if (message.getMethodName().equals("hello")) {
							instance.hello(message);
						} else {
							LOG_PRIVATE.error("Method:" + message.getMethodName() + " Not Found");
						}
					}
				}
			};
			return actor;
		}
	}
}