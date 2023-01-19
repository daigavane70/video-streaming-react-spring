import { Button, Card } from "antd";
import React from "react";

export default function Videos() {
  return (
    <div>
      {/* DND */}
      <Card className="h-[200px] flex items-center justify-center space-y-2 max-w-[800px] mx-auto">
        <div>Drag your files here</div>
        <Button>Upload</Button>
      </Card>
    </div>
  );
}
