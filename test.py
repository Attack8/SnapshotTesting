import asyncio
import websockets
import json

async def json_rpc_client():
    uri = "ws://localhost:25585"  # Replace with your WebSocket server URI
    async with websockets.connect(uri) as websocket:
        # Send a JSON-RPC request
        request = {
            "jsonrpc": "2.0",
            "method": "rpc.discover",
            # "params": [[{"name": "attack8"}]],
            "id": 1
        }
        await websocket.send(json.dumps(request))

        # Receive and parse the JSON-RPC response
        response_str = await websocket.recv()
        response = json.loads(response_str)

        if "result" in response:
            print(f"Result: {response['result']}")
        elif "error" in response:
            print(f"Error: {response['error']['message']}")

if __name__ == "__main__":
    asyncio.run(json_rpc_client())