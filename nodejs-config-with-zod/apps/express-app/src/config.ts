import { z } from "zod";
import dotenv from "dotenv";

dotenv.config({path: ".env.local"});

const AppConfigSchema = z.object({
    // Flat structure
    AzureADClientSecret: z.string().min(1, "The Azure Client Secret is required"),
    // Nested structure
    AzureAD: z.object({
        ClientSecret: z.string().min(1, "The Azure Client Secret is required")
    })
});

export type IAppConfig = z.infer<typeof AppConfigSchema>;

export const AppConfig: IAppConfig = AppConfigSchema.parse({
    AzureADClientSecret: process.env.AZURE_AD_CLIENT_ID,
    AzureAD: {
        ClientSecret: process.env.AZURE_AD_CLIENT_ID
    }
});